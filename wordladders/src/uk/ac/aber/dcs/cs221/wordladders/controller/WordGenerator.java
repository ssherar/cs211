package uk.ac.aber.dcs.cs221.wordladders.controller;

import uk.ac.aber.dcs.cs221.wordladders.model.*;
import java.util.*;
import java.io.*;

public abstract class WordGenerator {
	private File wordFile;
	protected Hashtable<String, Node> words;
	
	public WordGenerator(String fileName) {
		this.wordFile = new File(fileName);
		this.generateWords(); 
	}
	
	private void generateWords() {
		
	}
	
	public abstract void generateLadder();
}
