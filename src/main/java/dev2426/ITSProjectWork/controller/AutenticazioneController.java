package dev2426.ITSProjectWork.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import dev2426.ITSProjectWork.model.Utente;
import dev2426.ITSProjectWork.model.UtenteGUI;
import dev2426.ITSProjectWork.services.UtentiService;

@Controller
public class AutenticazioneController {

	@Autowired
	private UtentiService serv;

	@GetMapping("/login")
	public String showLogin() {
		return "/public/login";
	}

	@GetMapping("/register")
	public String showRegister(Model model) {
		model.addAttribute("utente", new UtenteGUI());
		return "/public/registrazione";
	}

	@PostMapping("/register")
	public String processRegistration(@ModelAttribute("utente") UtenteGUI utente, Model model) throws Exception {
		if (!utente.getPassword().equals(utente.getConfermaPassword())) {
			model.addAttribute("passwordError", "Le password non coincidono.");
			return "/public/registrazione";
		}

		Optional<Utente> utenteRegistratoOptional = serv.insert(utente);
		if (utenteRegistratoOptional.isPresent()) {
			model.addAttribute("success", "La registrazione e stata effettuata con successo");
			return "redirect:/login?success";
		} else {
			model.addAttribute("errorMessage", "Errore: Email già esistente");
			return "/public/registrazione";
		}
	}

	@GetMapping("/loading")
	public String showLoadingPage() {
		return "/public/loading";
	}

	@GetMapping("/")
	public String redirect() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication != null && authentication.isAuthenticated()
				&& !authentication.getName().equals("anonymousUser")) {
			return "redirect:/dashboard";
		} else {
			return "redirect:/login";
		}
	}

}