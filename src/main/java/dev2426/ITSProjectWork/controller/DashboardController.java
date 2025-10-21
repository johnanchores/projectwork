package dev2426.ITSProjectWork.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dev2426.ITSProjectWork.model.Azienda;
import dev2426.ITSProjectWork.model.Tirocinio;
import dev2426.ITSProjectWork.model.TirocinioGUI;
import dev2426.ITSProjectWork.services.AziendaService;
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
	private CompetenzaService cServ;
	@Autowired
	private TirocinioService tServ;

	@GetMapping("/dashboard")
	public String showHome(Model model) {
		List<Tirocinio> listaTir = tServ.getAll();
		List<TirocinioGUI> listaTirGUI = new ArrayList<>();

		for (Tirocinio t : listaTir) {
			Optional<Azienda> azienda = aServ.find(t.getId_azienda());

			listaTirGUI.add(new TirocinioGUI(azienda.orElse(null), t));

		}

		model.addAttribute("tirocini", listaTirGUI);
		return "/private/dashboard";
	}

}
