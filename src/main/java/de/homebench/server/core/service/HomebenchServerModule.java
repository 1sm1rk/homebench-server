package de.homebench.server.core.service;

import java.util.List;

import de.homebench.server.core.entity.MenuEntry;

public interface HomebenchServerModule {

	/**
	 * get submenu if exists
	 * @return 
	 */
	public List<MenuEntry>getSubMenu();
	
	/**
	 * get the info about the module
	 * @return
	 */
	public String getInfo();
}
