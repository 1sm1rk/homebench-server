package de.homebench.server.core.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import de.homebench.server.core.entity.MenuEntry;

@Service
public class HomebenchServerModuleSupervisor {

	Logger log = LoggerFactory.getLogger(HomebenchServerModuleSupervisor.class);
	
	List<MenuEntry> mainMenu = new ArrayList<MenuEntry>();
	
	Map<String, HomebenchServerModule> modules = new HashMap<String, HomebenchServerModule>();
	Map<String, List<MenuEntry>> menuEntries = new HashMap<String, List<MenuEntry>>();
	
	private HomebenchServerModuleSupervisor() {
		//by now static main menu
		mainMenu.add(new MenuEntry("home", "public", "/"));
		menuEntries.put("home", new ArrayList<MenuEntry>());
		
		mainMenu.add(new MenuEntry("module", "public", "/modules"));
		menuEntries.put("module", new ArrayList<MenuEntry>());
		
		mainMenu.add(new MenuEntry("status", "admin", "/status"));
		menuEntries.put("status", new ArrayList<MenuEntry>());
		
		mainMenu.add(new MenuEntry("admin", "admin", "/admin"));
		menuEntries.put("admin", new ArrayList<MenuEntry>());
		
		
	}
	
	public boolean registerModule(String name, HomebenchServerModule module, List<MenuEntry> sideMenu) {
		if (mainMenu.stream().filter(MenuEntry -> MenuEntry.getKey().equals(name)).findAny().orElse(null) != null) {
			if (module != null) {
				this.modules.put(name, module);
				for (MenuEntry entry : sideMenu) {
					this.menuEntries.get(name).add(entry);
				}
				log.info("module registered: ("+name+") "+module.getInfo());
				return true;
			} else 
				return false;
		} else {
			log.error("MenuEntry can not be found: "+name+", module not registered: "+module.getInfo());
			return false;
		}
		
	}
	
	public List<MenuEntry> getMainMenu() {
		return mainMenu;
	}
	
	public List<MenuEntry> getModulesMenu(String key) {
		//TODO: get modules for this mainMenu Entry, not everything!!
		return this.menuEntries.get(key);
	}
}
