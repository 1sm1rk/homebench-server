package de.homebench.server.core.service;

public interface HomebenchServerModule {

	/**
	 * get the menu text
	 * @return
	 */
	public String getLinkText();
	
	/**
	 * get the module url, controller must exist and implement it
	 * @return
	 */
	public String getLinkURL();
	
	/**
	 * get submenu if exists
	 * @return 
	 */
	public String getSubMenu();
	
	/**
	 * get the info about the module
	 * @return
	 */
	public String getInfo();
}
