package uk.ac.aber.dcs.cs221.wordladders;

import java.io.*;
import java.util.LinkedList;

import uk.ac.aber.dcs.cs221.wordladders.view.*;
import uk.ac.aber.dcs.cs221.wordladders.controller.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Manager.
 */
public class Manager {
	
	/** The class to write out to console. */
	private Screen screen;
	
	/** The file name for the dictionary files. */
	private String fileName;
	
	/** The Word Ladder Generator. */
	private WordGenerator gen;
	
	/**
	 * Instantiates a new manager, which gives initialises the class
	 * wide variables and runs {@link Manager#getFile()} and {@link Manager#init()}.
	 */
	public Manager() {
		screen = new Screen();
		gen = new WordGenerator();
		this.getFile();
		this.init();
	}
	
	/**
	 * The main method which runs the loop to collect values from the
	 * menu, and calls the relevant function depending on users input
	 * @see Manager#generate()
	 * @see Manager#discover()
	 * @see Manager#getFile()
	 */
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
	
	/**
	 * Gets the file name from the user. If it doesn't exist, it will
	 * ask until you it can find a valid file
	 */
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
	
	/**
	 * Generate a word ladder with a given word and amount of steps.
	 */
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
	
	/**
	 * Discover the shortest path between two different words.
	 */
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
