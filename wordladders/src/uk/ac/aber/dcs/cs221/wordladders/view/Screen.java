package uk.ac.aber.dcs.cs221.wordladders.view;

import uk.ac.aber.dcs.cs221.wordladders.controller.*;
import java.util.*;

public class Screen {
	private CLHandler cli;
	
	public Screen() {
		cli = new CLHandler();
		cli.write("----------------------------------------");
		cli.write(" Welcome to WordLadders assignment");
		cli.write("             (CS211)");
		cli.write(" Written by Samuel B Sherar (sbs1)");
		cli.write("----------------------------------------");
		cli.write();
	}
	
	public int writeMenu() {
		cli.write("Menu");
		cli.write("======");
		cli.write("1) Generate a Word Ladder from a word");
		cli.write("2) Discover the smallest change from one word to another");
		cli.write("0) To quit the application");
		cli.write();
		cli.prompt("Please enter a value > ");
		int tmp = cli.readInt();
		return tmp;
	}
	
	public String writeFilePrompt() {
		cli.prompt("Please enter a file path to gather words from > ");
		String fileName = cli.readString();
		cli.write();
		return fileName;
	}
	
	public int getInt(String message) {
		cli.prompt(message + " >");
		int retVal = cli.readInt();
		cli.write();
		return retVal;
	}
	
	public String getString(String message) {
		cli.prompt(message + " >");
		String retVal = cli.readString();
		cli.write();
		return retVal;
	}
	
	public void writeError(String errorMessage) {
		cli.write(errorMessage);
		cli.write();
	}
	
	public void writeWords(String[] words) {
		String printVal = "";
		for(int i = 0; i < words.length; i++) {
			printVal += words[i] + " -> ";
		}
		printVal = printVal.substring(0, printVal.length() - 4);
		cli.write(printVal);
		cli.write();
	}
        
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
