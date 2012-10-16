package uk.ac.aber.dcs.cs221.wordladders.controller;

import uk.ac.aber.dcs.cs221.wordladders.model.*;

import java.util.*;
import java.io.*;

public abstract class WordGenerator {
	private File wordFile;
	protected Hashtable<String, Node> words;
	
	public WordGenerator(String fileName) {
		this.wordFile = new File(fileName);
	}
	
	private void generateWords() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(wordFile));
		for(String line; (line = br.readLine()) != null;) {
			if(line.length() > 1) {
				String[] wordsTmp;
				line = line.replaceAll("[\\p{P}-[._]]", "");
				wordsTmp = line.split(" ");
				for(int i = 0; i < line.length(); i++) {
					String tmp = wordsTmp[i].toLowerCase();
					if(!this.words.containsKey(tmp)) {
						words.put(tmp, new Node(tmp));
					}
				}
			}
			
		}
		br.close();
	}
	
	public void setFile(String fileName) throws IOException {
		this.wordFile = new File(fileName);
		this.generateWords();
	}
	
	public abstract void generateLadder();
}
