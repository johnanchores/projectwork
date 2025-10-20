package dev2426.ITSProjectWork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dev2426.ITSProjectWork.model.Tirocinio;
import dev2426.ITSProjectWork.services.AziendaService;
import dev2426.ITSProjectWork.services.CompetenzaService;
import dev2426.ITSProjectWork.services.TirocinioService;
import dev2426.ITSProjectWork.services.UtentiService;

@Controller
public class DashboardController {
	
	@Autowired
	private AziendaService aServ;
	private UtentiService uServ;
	private CompetenzaService cServ;
	private TirocinioService tServ;
	
	@GetMapping("/home")
	public String showHome(Model model) {
		List<Tirocinio> listaTir = tServ.getAll();
		model.addAttribute("tirocini", listaTir);
		return "dashboard";
	}
	
}
