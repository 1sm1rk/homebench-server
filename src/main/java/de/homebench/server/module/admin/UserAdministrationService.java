package de.homebench.server.module.admin;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import de.homebench.server.core.entity.MenuEntry;
import de.homebench.server.core.service.HomebenchServerModule;
import de.homebench.server.core.service.HomebenchServerModuleSupervisor;
import jakarta.annotation.PostConstruct;

@Service
public class UserAdministrationService implements HomebenchServerModule {

	Logger log = LoggerFactory.getLogger(UserAdministrationService.class);
	HomebenchServerModuleSupervisor supervisor;
	List<MenuEntry> sideMenu = new ArrayList<MenuEntry>();
	
	public UserAdministrationService(HomebenchServerModuleSupervisor supervisor) {
		this.supervisor = supervisor;
		sideMenu.add(new MenuEntry("useradmin.user", "admin", "/modules/usermanagement"));
		sideMenu.add(new MenuEntry("useradmin.groups", "admin", "/modules/groupmanagement"));
	}
	
	@Override
	public List<MenuEntry> getSubMenu() {
		return this.sideMenu;
	}

	@Override
	public String getInfo() {
		return "Admin module Usermanagement, (2024) D.Mueller";
	}

	@PostConstruct
	public void initModule() {
		if (this.supervisor != null) {
			this.supervisor.registerModule("admin", this, this.sideMenu);
		} else {
			log.error("supervisor not defined!!");
		}
	}
}
