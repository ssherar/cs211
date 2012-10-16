package uk.ac.aber.dcs.cs221.wordladders;

import uk.ac.aber.dcs.cs221.wordladders.view.*;

public class Manager {
	private Screen screen;
	private String fileName;
	
	public Manager() {
		screen = new Screen();
		this.fileName = this.getFile();
		this.init();
	}
	
	public void init() {
		this.screen.writeMenu();
	}
	
	public void getFile() {
	}
}
