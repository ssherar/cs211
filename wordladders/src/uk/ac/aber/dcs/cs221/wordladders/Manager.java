package uk.ac.aber.dcs.cs221.wordladders;

import java.io.*;

import uk.ac.aber.dcs.cs221.wordladders.view.*;
import uk.ac.aber.dcs.cs221.wordladders.controller.*;

public class Manager {
	private Screen screen;
	private String fileName;
	private WordGenerator gen;
	
	public Manager() {
		screen = new Screen();
		this.getFile();
		this.init();
		gen = null;
	}
	
	public void init() {
		int index = 0;
		do {
			index = this.screen.writeMenu();
		} while(index != 0);
	}
	
	public void getFile() {
		gen = new WordGenerator();
		
		do {
			try {
				this.fileName = this.screen.writeFilePrompt();
				gen.setFile(fileName);
			} catch (IOException e) {
				this.screen.writeError("Cannot find: " + e.getMessage() + ". Please try again");
			}
		} while(!gen.hasFile());
	}
}
