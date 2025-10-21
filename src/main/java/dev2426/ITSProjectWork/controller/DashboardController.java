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
import dev2426.ITSProjectWork.model.Tirocinio;
import dev2426.ITSProjectWork.model.TirocinioGUI;
import dev2426.ITSProjectWork.model.Utente;
import dev2426.ITSProjectWork.services.CandidaturaService;
import dev2426.ITSProjectWork.services.TirocinioService;
import dev2426.ITSProjectWork.services.UtentiService;

@Controller
public class DashboardController {

    @Autowired
    private TirocinioService tServ;
    
    @Autowired
    private UtentiService uServ;
    
    @Autowired 
    private CandidaturaService caServ;


    @GetMapping("/dashboard")
    public String showHome(Model model) {
        
        List<Tirocinio> listaTir = tServ.getAll();
        
        List<TirocinioGUI> listaCompleta = new ArrayList<>();
        
        for (Tirocinio t : listaTir) {
            TirocinioGUI tg = new TirocinioGUI();
            
            tg.setId_tirocinio(t.getIdTirocinio());
            tg.setMansione(t.getMansione());
            tg.setDurata(t.getDurata());
            tg.setDescrizione(t.getDescrizione());
            
            
            if (t.getAzienda() != null) {
                tg.setNomeAzienda(t.getAzienda().getNome());
            }

            if (t.getCompetenze() != null) {
               
                List<String> nomiCompetenze = t.getCompetenze().stream()
                                                .map(Competenza::getNome)
                                                .toList();
                tg.setNome_competenza(nomiCompetenze); 
            }
            
            listaCompleta.add(tg);
        }

        model.addAttribute("tirocini", listaCompleta);
        return "private/dashboard";
    }
    
	@PostMapping("/candidature")
	public String Candidatura(@ModelAttribute("Candidatura") Candidatura newCand, Principal p,
			@RequestParam Long id_tirocinio) {

		if (p == null) {
			return "redirect:/login";
		}
		
		Optional<Utente> userOptional = uServ.findByEmail(p.getName());
		
		if (userOptional.isPresent()) {
			Utente user = userOptional.get();
			newCand.setId_utente(user.getIdUtente());
			newCand.setIdTirocinio(id_tirocinio);
			newCand.setStato(0); 
			caServ.insert(newCand);
		}
		
		return "redirect:/dashboard";
	}
}