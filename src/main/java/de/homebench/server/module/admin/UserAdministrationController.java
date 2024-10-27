package de.homebench.server.module.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserAdministrationController {

	@GetMapping("/module/usermanagement")
	public String userAdministrationLandingPage(Model model) {
		
		
		model.addAttribute("main_title","Benutzerverwaltung");
		model.addAttribute("main_content","wir verwalten benutzer");
		return "tpl_maincontent :: maincontent";
	}
}
