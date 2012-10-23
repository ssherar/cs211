package uk.ac.aber.dcs.cs221.wordladders.view;

import uk.ac.aber.dcs.cs221.wordladders.controller.*;
import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Screen.
 */
public class Screen {
	
	/** The cli. */
	private CLHandler cli;
	
	/**
	 * Instantiates a new screen.
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
	 * Write menu.
	 *
	 * @return the int
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
	 * Write file prompt.
	 *
	 * @return the string
	 */
	public String writeFilePrompt() {
		cli.prompt("Please enter a file path to gather words from > ");
		String fileName = cli.readString();
		cli.write();
		return fileName;
	}
	
	/**
	 * Gets the int.
	 *
	 * @param message the message
	 * @return the int
	 */
	public int getInt(String message) {
		cli.prompt(message + " > ");
		int retVal = cli.readInt();
		cli.write();
		return retVal;
	}
	
	/**
	 * Gets the string.
	 *
	 * @param message the message
	 * @return the string
	 */
	public String getString(String message) {
		cli.prompt(message + " > ");
		String retVal = cli.readString();
		cli.write();
		return retVal;
	}
	
	/**
	 * Write error.
	 *
	 * @param errorMessage the error message
	 */
	public void writeError(String errorMessage) {
		cli.write(errorMessage);
		cli.write();
	}
	
	/**
	 * Write words.
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
