package dev2426.ITSProjectWork.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dev2426.ITSProjectWork.model.Azienda;
import dev2426.ITSProjectWork.model.CandidaturaGUI;
import dev2426.ITSProjectWork.model.Competenza;
import dev2426.ITSProjectWork.model.Tirocinio;
import dev2426.ITSProjectWork.model.TirocinioAdminGUI;
import dev2426.ITSProjectWork.model.TirocinioGUI;
import dev2426.ITSProjectWork.services.AziendaService;
import dev2426.ITSProjectWork.services.CandidaturaService;
import dev2426.ITSProjectWork.services.CompetenzaService;
import dev2426.ITSProjectWork.services.TirocinioService;

@Controller
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    @Autowired private CandidaturaService candidaturaService;
    @Autowired private TirocinioService tirocinioService;
    @Autowired private AziendaService aziendaService;
    @Autowired private CompetenzaService competenzaService;

    @GetMapping("/admin")
    public String showPage(Model model) {
        List<CandidaturaGUI> listaCandidature = candidaturaService.getAllCandGUI();
        List<Azienda> listaAziende = aziendaService.getAll();
        List<Competenza> listaCompetenze = competenzaService.getAll();
        
        model.addAttribute("listaCandidature", listaCandidature);
        model.addAttribute("listaAziende", listaAziende);
        model.addAttribute("listaCompetenze", listaCompetenze);

        model.addAttribute("nuovoTirocinio", new TirocinioAdminGUI());
        
        return "/private/profiloadmin";
    }

    @PostMapping("/registraTirocinio")
    public String registerTirocinio(@ModelAttribute("nuovoTirocinio") TirocinioAdminGUI tirocinioDto, 
                                    RedirectAttributes redirectAttributes) { 
        
        Optional<Azienda> aziendaOptional = aziendaService.find(tirocinioDto.getAziendaId()); 
        
        if (aziendaOptional.isPresent()) {
            Azienda azienda = aziendaOptional.get();
            List<Competenza> competenzeSelezionate = competenzaService.findAllByIds(tirocinioDto.getCompetenzeId());

            
            Tirocinio t = new Tirocinio();
            t.setMansione(tirocinioDto.getMansione());
            t.setDurata(tirocinioDto.getDurata());
            t.setDescrizione(tirocinioDto.getDescrizione());
            t.setAzienda(azienda);
            t.setCompetenze(competenzeSelezionate);
            
            tirocinioService.insert(t);

            redirectAttributes.addFlashAttribute("successMessage", "Tirocinio aggiunto con successo!");
            
        } else {
        	
            redirectAttributes.addFlashAttribute("errorMessage", "Errore: l'azienda selezionata non è valida.");
        }
        
        return "redirect:/admin";
    }
}