package dev2426.ITSProjectWork.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import dev2426.ITSProjectWork.model.CandidaturaGUI;
import dev2426.ITSProjectWork.model.Utente;
import dev2426.ITSProjectWork.model.UtenteGUI;
import dev2426.ITSProjectWork.services.CandidaturaService;
import dev2426.ITSProjectWork.services.UtentiService;

@Controller
public class ProfiloController {

	@Autowired
	private UtentiService uServ;

	@Autowired
	private CandidaturaService candServ;

	@GetMapping("/profilo")
	public String showProfile(@AuthenticationPrincipal UserDetails dettagli, Model modello) {
		String email = dettagli.getUsername();
		Optional<Utente> optionalUtente = uServ.findByEmail(email);

		if (optionalUtente.isPresent()) {
			Utente utente = optionalUtente.get();

			List<CandidaturaGUI> listaCandidature = candServ.getUserCandidatureGui(utente);
			modello.addAttribute("listaCandidature", listaCandidature);

			modello.addAttribute("utente", utente);

			UtenteGUI utenteGui = new UtenteGUI();
			utenteGui.setNome(utente.getNome());
			utenteGui.setCognome(utente.getCognome());

			modello.addAttribute("utenteGUI", utenteGui);
		} else {
			return "redirect:/logout";
		}

		return "/private/profilo";
	}

	@PostMapping("/profilo")
	public String processProfileUpdate(@AuthenticationPrincipal UserDetails dettagli,
			@ModelAttribute("utenteGUI") UtenteGUI datiForm, Model modello) {

		if (datiForm.getPasswordNuova() != null && !datiForm.getPasswordNuova().isEmpty()) {
			if (!datiForm.getPasswordNuova().equals(datiForm.getConfermaPassword())) {
				modello.addAttribute("updateError", "La nuova password e la conferma non corrispondono.");
				return showProfile(dettagli, modello);
			}
		}

		String email = dettagli.getUsername();
		Optional<Utente> optionalUtente = uServ.findByEmail(email);

		if (optionalUtente.isEmpty()) {
			return "redirect:/logout";
		}
		long idUtente = optionalUtente.get().getIdUtente();

		if (datiForm.getCurriculumFile() != null && !datiForm.getCurriculumFile().isEmpty()) {
			try {
				uServ.saveCurriculumFile(idUtente, datiForm.getCurriculumFile());
			} catch (Exception e) {
				modello.addAttribute("updateError", "Errore nel caricamento del Curriculum: " + e.getMessage());
				return showProfile(dettagli, modello);
			}
		}

		String errore = uServ.update(idUtente, datiForm);

		if (errore == null) {
			return "redirect:/profilo?success";
		} else {
			modello.addAttribute("updateError", errore);
			return showProfile(dettagli, modello);
		}
	}
}