package de.homebench.server.core.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class HomebenchServerModuleSupervisor {

	Map<String, HomebenchServerModule> modules = new HashMap<String, HomebenchServerModule>();
	Map<String, String> menuEntries = new HashMap<String, String>();
	
	public boolean registerModule(String name, HomebenchServerModule module) {
		if (module != null) {
			this.modules.put(name, module);
			this.menuEntries.put(module.getLinkText(), module.getLinkURL());
			System.out.println(module.getLinkText());
			return true;
		} else 
			return false;
			
	}
	
	public Map<String, String> getModulesMenu() {
		return this.menuEntries;
	}
}
