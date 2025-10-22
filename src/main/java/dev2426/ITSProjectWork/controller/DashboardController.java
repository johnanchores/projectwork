package dev2426.ITSProjectWork.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dev2426.ITSProjectWork.model.Candidatura;
import dev2426.ITSProjectWork.model.Tirocinio;
import dev2426.ITSProjectWork.model.TirocinioGUI;
import dev2426.ITSProjectWork.model.Utente;
import dev2426.ITSProjectWork.services.CandidaturaService;
import dev2426.ITSProjectWork.services.TirocinioService;
import dev2426.ITSProjectWork.services.UtentiService;

@Controller
public class DashboardController {

	@Autowired
	private UtentiService utentiServ;

	@Autowired
	private CandidaturaService candServ;

	@Autowired
	private TirocinioService tiroServ;

	@GetMapping("/dashboard")
	public String showHome(Model model, Principal p) {
		
		if (p != null) {
            Optional<Utente> userOptional = utentiServ.findByEmail(p.getName());
            if (userOptional.isPresent()) {
                model.addAttribute("utente", userOptional.get());
            }
        }
		List<Tirocinio> listaTir = tiroServ.getAll();	
		
		List<TirocinioGUI> listaCompleta = new ArrayList<>();
		
		for (Tirocinio t : listaTir) {
			TirocinioGUI tg = new TirocinioGUI();

			tg.setId_tirocinio(t.getIdTirocinio());
			tg.setMansione(t.getMansione());
			tg.setDurata(t.getDurata());
			tg.setDescrizione(t.getDescrizione());
			tg.setOrario_lavoro(t.getOrario_lavoro());

			if (t.getAzienda() != null) {
                tg.setNomeAzienda(t.getAzienda().getNome());
            }
            if (t.getCompetenze() != null) {
                tg.setCompetenze(t.getCompetenze());
            }
		
			listaCompleta.add(tg);

		}
		model.addAttribute("tirocini", listaCompleta);
		return "/private/dashboard";
	}

	@PostMapping("/candidature")
	public String Candidatura(Principal p, @RequestParam("id_tirocinio") long id_tirocinio, Model model) {

	    if (p == null) {
	        return "redirect:/login";
	    }

	    Optional<Utente> userOptional = utentiServ.findByEmail(p.getName());
	    Optional<Tirocinio> tirocinioOptional = tiroServ.find(id_tirocinio); 

	    if (userOptional.isPresent() && tirocinioOptional.isPresent()) {
	        Utente user = userOptional.get();
	        Tirocinio tirocinio = tirocinioOptional.get();
	        
	        Candidatura newCand = new Candidatura();
	        newCand.setUtente(user);
	        newCand.setTirocinio(tirocinio);
	        newCand.setStato(0);
	        
	        try {
	            candServ.insert(newCand);
	            
	            
	            return "redirect:/dashboard?success"; 
	            
	        } catch (IllegalStateException e) {
	            model.addAttribute("candidaturaError", e.getMessage());
	            return showHome(model, p);
	        }
	    } else {
	        model.addAttribute("candidaturaError", "Utente o tirocinio non validi.");
	        return showHome(model, p);
	    }
	}

}
