package uk.co.samsherar.wordladders.view;

import uk.co.samsherar.wordladders.controller.*;

import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Screen.
 */
public class Screen {
	
	/** The commandline interface class. */
	private CLHandler cli;
	
	/**
	 * Instantiates a new screen. Just writes out a
	 * header.
	 */
	public Screen() {
		cli = new CLHandler();
		cli.write("----------------------------------------");
		cli.write(" Welcome to WordLadders assignment");
		cli.write("             (CS211)");
		cli.write(" Written by Samuel B Sherar (sbs1)");
		cli.write("----------------------------------------");
		cli.write();
	}
	
	/**
	 * Write the menu.
	 *
	 * @return the integer choice from the menu
	 */
	public int writeMenu() {
		cli.write("Menu");
		cli.write("======");
		cli.write("1) Generate a Word Ladder from a word");
		cli.write("2) Discover the smallest change from one word to another");
		cli.write("3) Use a different dictionary file");
		cli.write("0) To quit the application");
		cli.write();
		cli.prompt("Please enter a value > ");
		int tmp = cli.readInt();
		return tmp;
	}
	
	/**
	 * Write a file prompt to the screen and
	 * gathers the file path from users input
	 *
	 * @return the file path as a string
	 */
	public String writeFilePrompt() {
		cli.prompt("Please enter a file path to gather words from > ");
		String fileName = cli.readString();
		cli.write();
		return fileName;
	}
	
	/**
	 * Retrieves an integer value from the user
	 * when prompted with a message
	 *
	 * @param message the message
	 * @return the integer value
	 */
	public int getInt(String message) {
		cli.prompt(message + " > ");
		int retVal = cli.readInt();
		return retVal;
	}
	
	/**
	 * Retrieves a String value from the user
	 * when prompted with a message
	 *
	 * @param message the message
	 * @return the string value
	 */
	public String getString(String message) {
		cli.prompt(message + " > ");
		String retVal = cli.readString();
		cli.write();
		return retVal;
	}
	
	/**
	 * Write an error to the users screen and prompting
	 * the user to acknowledge
	 *
	 * @param errorMessage the error message
	 */
	public void writeError(String errorMessage) {
		cli.write(errorMessage);
		cli.write();
	}
	
	/**
	 * Display a list of words in a human
	 * readable manor.
	 *
	 * @param words the words
	 */
	public void writeWords(LinkedList<String> words) {
		String printVal = "";
		for(int i = 0; i < words.size(); i++) {
			printVal += words.get(i) + " -> ";
		}
		printVal = printVal.substring(0, printVal.length() - 4);
		cli.write(printVal);
		cli.write();
	}
}
