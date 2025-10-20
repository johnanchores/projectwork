package dev2426.ITSProjectWork.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import dev2426.ITSProjectWork.model.Utente;
import dev2426.ITSProjectWork.model.UtenteGUI;
import dev2426.ITSProjectWork.services.UtentiService;

@Controller
public class ProfiloController {
	
	@Autowired
	private UtentiService uServ;
	
	@GetMapping("/profilo") 
	public String showProfile(@AuthenticationPrincipal UserDetails dettagli, Model modello){
	    String email = dettagli.getUsername();
	    Optional<Utente> optionalUtente = uServ.findByEmail(email);
		
	    if (optionalUtente.isPresent()) {
	        Utente utente = optionalUtente.get();
	        modello.addAttribute("utente", utente);
	        
	        UtenteGUI utenteGui = new UtenteGUI();
	        utenteGui.setNome(utente.getNome());
	        utenteGui.setCognome(utente.getCognome());
	        
	        modello.addAttribute("utenteGUI", utenteGui);
	    } else {
	        return "redirect:/logout";
	    }
		
	    return "profilo";
	}

	@PostMapping("/profilo")
	public String processProfileUpdate(@AuthenticationPrincipal UserDetails dettagli,
			@ModelAttribute("utenteGUI") UtenteGUI datiForm,
            Model modello) {
        
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
	    
	    boolean successo = uServ.update(idUtente, datiForm);
		
	    if (successo) {
	        return "redirect:/profilo?success";
	    } else {
            modello.addAttribute("updateError", "La password corrente inserita non è corretta.");
            return showProfile(dettagli, modello);
	    }
	}
}