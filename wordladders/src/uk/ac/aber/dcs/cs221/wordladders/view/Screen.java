package uk.ac.aber.dcs.cs221.wordladders.view;

import uk.ac.aber.dcs.cs221.wordladders.controller.*;

public class Screen {
	private CLWriter cli;
	
	public Screen() {
		cli = new CLWriter();
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
}
