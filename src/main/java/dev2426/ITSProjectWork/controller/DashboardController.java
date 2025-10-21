package dev2426.ITSProjectWork.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dev2426.ITSProjectWork.model.Candidatura;
import dev2426.ITSProjectWork.model.Competenza;
import dev2426.ITSProjectWork.model.Azienda;
import dev2426.ITSProjectWork.model.Tirocinio;
import dev2426.ITSProjectWork.model.TirocinioGUI;
import dev2426.ITSProjectWork.model.Utente;
import dev2426.ITSProjectWork.services.AziendaService;
import dev2426.ITSProjectWork.services.CandidaturaService;
import dev2426.ITSProjectWork.services.CompetenzaService;
import dev2426.ITSProjectWork.services.TirocinioService;
import dev2426.ITSProjectWork.services.UtentiService;

@Controller
public class DashboardController {

	@Autowired
	private AziendaService aServ;

	@Autowired
	private UtentiService uServ;

	@Autowired
	private CandidaturaService cServ;

	@Autowired
	private TirocinioService tServ;

	@Autowired
	private CompetenzaService coServ;

	@GetMapping("/dashboard")
	public String showHome(Model model) {
		List<Tirocinio> listaTir = tServ.getAll();
		List<Azienda> listaA = aServ.getAll();
		List<TirocinioGUI> listaCompleta = new ArrayList<>();
		for (Tirocinio t : listaTir) {
			TirocinioGUI tg = new TirocinioGUI();
			for (Azienda a : listaA) {

				if (t.getId_azienda() == a.getIdAzienda()) {

					tg.setDescrizione(t.getDescrizione());
					tg.setDurata(t.getDurata());
					tg.setMansione(t.getMansione());
					tg.setNomeAzienda(a.getNome());
					tg.setId_tirocinio(t.getIdTirocinio());

				}

			}
		
			listaCompleta.add(tg);

		}
		model.addAttribute("tirocini", listaCompleta);
		return "/private/dashboard";
	}

	@PostMapping("/candidature")
	public String Candidatura(@ModelAttribute("Candidatura") Candidatura newCand, Principal p,
			@RequestParam Long id_tirocinio) {

		if (p == null) {
			return "redirect:/login";
		}
		String emailUtenteLoggato = p.getName();
		Optional<Utente> userOptional = uServ.findByEmail(emailUtenteLoggato);
		if (userOptional.isPresent()) {
			Utente user = userOptional.get();
			newCand.setId_utente(user.getIdUtente());
		}
		newCand.setIdTirocinio(id_tirocinio);
		newCand.setStato(0);
		cServ.insert(newCand);
		return "redirect:/home";
	}

}
