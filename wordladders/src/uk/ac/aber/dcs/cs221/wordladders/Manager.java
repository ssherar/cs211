package uk.ac.aber.dcs.cs221.wordladders;

import java.io.*;
import java.util.LinkedList;

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
					this.discover();
					break;
				case 3:
					this.getFile();
				default:
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
		try {
			screen.writeWords(gen.generateLadder(word, steps));
		} catch(WordLadderException e) {
			screen.writeError("Word Error: " + e.getMessage());
		}
	}
	
	public void discover() {
		
		String startWord, endWord;
		
		startWord = this.screen.getString("Please enter the start word");
		endWord = this.screen.getString("Please enter the end word");
		try {
			LinkedList<String> ladder = gen.discover(startWord, endWord);
			screen.writeWords(ladder);
		} catch(WordLadderException e) {
			screen.writeError("Word Error: " + e.getMessage());
		}
	}
}
