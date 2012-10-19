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
		gen = new WordGenerator();
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
		try {
			gen.setFile(this.fileName);
			gen.generateAssociations();
		} catch(IOException e) {
			this.screen.writeError("File error: " + e.getMessage());
		}
	}
	
	public void generate() {
		
		String word;
		int steps;
	
		
		word = this.screen.getString("Please enter a word to start from");
		steps = this.screen.getInt("And the number of steps");
		screen.writeWords(gen.generateLadder(word, steps));
	}
}
