package de.homebench.server.module.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import de.homebench.server.core.service.HomebenchServerModule;
import de.homebench.server.core.service.HomebenchServerModuleSupervisor;
import jakarta.annotation.PostConstruct;

@Service
public class UserAdministrationService implements HomebenchServerModule {

	Logger log = LoggerFactory.getLogger(UserAdministrationService.class);
	HomebenchServerModuleSupervisor supervisor;
	
	public UserAdministrationService(HomebenchServerModuleSupervisor supervisor) {
		this.supervisor = supervisor;
	}
	
	@Override
	public String getLinkText() {
		// TODO localized names!
		return "Benutzerverwaltung";
	}

	@Override
	public String getLinkURL() {
		return "/module/usermanagement";
	}

	@Override
	public String getSubMenu() {
		return "usermanagement submenu";
	}

	@Override
	public String getInfo() {
		return "(2024) D.Mueller";
	}

	@PostConstruct
	public void initModule() {
		if (this.supervisor != null) {
			this.supervisor.registerModule("UserAdministration", this);
		} else {
			log.error("supervisor not defined!!");
		}
	}
}
