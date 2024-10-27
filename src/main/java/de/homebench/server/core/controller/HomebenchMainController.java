package de.homebench.server.core.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import de.homebench.server.core.service.HomebenchServerModuleSupervisor;
import de.homebench.server.module.admin.UserAdministrationService;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomebenchMainController {
	Logger log = LoggerFactory.getLogger(HomebenchMainController.class);
	HomebenchServerModuleSupervisor supervisor;
	private HttpSession session;
	
	public HomebenchMainController(HttpSession session, HomebenchServerModuleSupervisor supervisor) {
		this.session = session;
		this.supervisor = supervisor;
	}
	
	@GetMapping("")
	public String home(Model model) {
		String sessionId = session.getId();
		System.out.println(sessionId);
		
		model.addAttribute("main_title","Welcome !");
		model.addAttribute("main_content","Let's get started!");
		model.addAttribute("modules", this.supervisor.getModulesMenu());
		return "home";
	}
}
