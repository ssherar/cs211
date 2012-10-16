package uk.ac.aber.dcs.cs221.wordladders;

import uk.ac.aber.dcs.cs221.wordladders.view.*;
import uk.ac.aber.dcs.cs221.wordladders.controller.*;

public class Manager {
	private Screen screen;
	private String fileName;
	private WordCreator gen;
	
	public Manager() {
		screen = new Screen();
		this.getFile();
		this.init();
		gen = null;
	}
	
	public void init() {
		this.screen.writeMenu();
	}
	
	public void getFile() {
		this.fileName = this.screen.writeFilePrompt();
	}
}
