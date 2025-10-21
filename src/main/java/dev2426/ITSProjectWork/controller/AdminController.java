package dev2426.ITSProjectWork.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dev2426.ITSProjectWork.model.Candidatura;
import dev2426.ITSProjectWork.model.CandidaturaGUI;
import dev2426.ITSProjectWork.services.CandidaturaService;

@Controller
public class AdminController {
	
	@Autowired
	private CandidaturaService servizioCandidatura;
	
	@GetMapping("/amministrazione")
	public String showPage() {
		return "redirect:/profiloadmin";
	}
	
	@GetMapping("/visualizzaCandidature")
	public void showCandidature(Model model) {
		List<CandidaturaGUI> listaCandidatureVisual = servizioCandidatura.getAllCandGUI();
		model.addAttribute("listaCandidature", listaCandidatureVisual);
		
	}

}
