package dev2426.ITSProjectWork.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dev2426.ITSProjectWork.model.Azienda;
import dev2426.ITSProjectWork.model.CandidaturaGUI;
import dev2426.ITSProjectWork.model.Tirocinio;
import dev2426.ITSProjectWork.model.TirocinioGUI;
import dev2426.ITSProjectWork.services.AziendaService;
import dev2426.ITSProjectWork.services.CandidaturaService;
import dev2426.ITSProjectWork.services.TirocinioService;

@Controller
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
	
	@Autowired
	private CandidaturaService servizioCandidatura;
	@Autowired
	private TirocinioService servizioTirocini;
	@Autowired
	private AziendaService servizioAzienda;
	
	@GetMapping("/admin")
	public String showPage(Model model) {
		List<CandidaturaGUI> listaCandidatureVisual = servizioCandidatura.getAllCandGUI();
		List<Azienda> listaAziende = servizioAzienda.getAll();
		model.addAttribute("listaCandidature", listaCandidatureVisual);	
		model.addAttribute("listaAziende", listaAziende);
		return "/private/profiloadmin";
	}
	
	@PostMapping("/registraTirocinio")
	public String registerTirocinio(@ModelAttribute TirocinioGUI nuovoTirocinio, @ModelAttribute Azienda azienda) {
		Tirocinio t = new Tirocinio();
		t.setMansione(nuovoTirocinio.getMansione());
		t.setCompetenze(nuovoTirocinio.getCompetenze());
		t.setAzienda(azienda);
		t.setDescrizione(nuovoTirocinio.getDescrizione());
		t.setDurata(nuovoTirocinio.getDurata());
		servizioTirocini.insert(t);

		return "/private/profiloadmin";
	}

}
