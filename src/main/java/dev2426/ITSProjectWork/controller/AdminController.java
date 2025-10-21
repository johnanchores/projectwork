package dev2426.ITSProjectWork.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import dev2426.ITSProjectWork.model.CandidaturaGUI;
import dev2426.ITSProjectWork.services.CandidaturaService;

@Controller
public class AdminController {
	
	@Autowired
	private CandidaturaService servizioCandidatura;
	
	@GetMapping("/admin")
	public String showPage(Model model) {
		List<CandidaturaGUI> listaCandidatureVisual = servizioCandidatura.getAllCandGUI();
		model.addAttribute("listaCandidature", listaCandidatureVisual);	
		return "redirect:/private/profiloadmin";
	}

}
