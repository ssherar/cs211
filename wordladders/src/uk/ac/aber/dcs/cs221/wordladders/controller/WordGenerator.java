package uk.ac.aber.dcs.cs221.wordladders.controller;

public class WordGenerator extends WordCreator {
	public WordGenerator() {
		
	}
	
	public String[] generateLadder(String word, int steps) {
		String[] retVal = new String[1];
		this.generateAssociations(word);
		return retVal;
	}
}
