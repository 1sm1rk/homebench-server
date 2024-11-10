package de.homebench.server.core.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import de.homebench.server.core.service.HomebenchServerModuleSupervisor;
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
		log.info("session id: "+sessionId);
		
		model.addAttribute("main_menu", supervisor.getMainMenu());
		model.addAttribute("main_title","Welcome !");
		model.addAttribute("main_content","Let's get started!");
		model.addAttribute("modules", this.supervisor.getModulesMenu("home"));
		return "home";
	}
	
	@GetMapping("/modules")
	public String modules(Model model) {
		String sessionId = session.getId();
		log.info("session id: "+sessionId);
		
		model.addAttribute("main_menu", supervisor.getMainMenu());
		model.addAttribute("main_title","Welcome !");
		model.addAttribute("main_content","Let's get started!");
		model.addAttribute("modules", this.supervisor.getModulesMenu("modules"));
		return "home";
	}
	
	@GetMapping("/status")
	public String status(Model model) {
		String sessionId = session.getId();
		log.info("session id: "+sessionId);
		
		model.addAttribute("main_menu", supervisor.getMainMenu());
		model.addAttribute("main_title","Welcome !");
		model.addAttribute("main_content","Let's get started!");
		model.addAttribute("modules", this.supervisor.getModulesMenu("status"));
		return "home";
	}
	
	@GetMapping("/admin")
	public String admin(Model model) {
		String sessionId = session.getId();
		log.info("session id: "+sessionId);
		
		model.addAttribute("main_menu", supervisor.getMainMenu());
		model.addAttribute("main_title","Welcome !");
		model.addAttribute("main_content","Let's get started!");
		model.addAttribute("modules", this.supervisor.getModulesMenu("admin"));
		return "home";
	}
}
