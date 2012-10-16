package uk.ac.aber.dcs.cs221.wordladders;

import java.io.*;

import uk.ac.aber.dcs.cs221.wordladders.view.*;
import uk.ac.aber.dcs.cs221.wordladders.controller.*;

public class Manager {
	private Screen screen;
	private String fileName;
	
	public Manager() {
		screen = new Screen();
		this.getFile();
		this.init();
	}
	
	public void init() {
		int index = 0;
		do {
			index = this.screen.writeMenu();
			switch(index) {
				case 1:
					this.generate();
					break;
				case 2:
					break;
			}
		} while(index != 0);
	}
	
	public void getFile() {
		File wordFile;
		do {
			this.fileName = this.screen.writeFilePrompt();
			wordFile = new File(fileName);
			if(!wordFile.exists()) {
				this.screen.writeError("File not found: " + fileName + ". Please enter a valid file path and name");
			}
		} while(!wordFile.exists());
	}
	
	public void generate() {
		WordGenerator gen = new WordGenerator();
		String word;
		int steps;
		try {
			gen.setFile(this.fileName);
		} catch(IOException e) {
			this.screen.writeError("File error: " + e.getMessage());
		}
		
		word = this.screen.getString("Please enter a word to start from");
		steps = this.screen.getInt("And the number of steps");
		gen.generateLadder(word, steps);
		//this.screen.writeWords());
	}
}
