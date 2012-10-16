package uk.ac.aber.dcs.cs221.wordladders.controller;

import uk.ac.aber.dcs.cs221.wordladders.model.*;

import java.util.*;
import java.io.*;

public abstract class WordCreator {
	private File wordFile;
	protected Hashtable<String, Node> words;
	
	public WordCreator() {
		this.words = new Hashtable<String, Node>();
		this.wordFile = null;
	}
	
	private void generateWords() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(wordFile));
		for(String line; (line = br.readLine()) != null;) {
			if(line.length() > 1) {
				String tmp;
				line = line.replaceAll("[\\p{P}-[._]]", "");
				if(line.indexOf(" ") == -1) {
					tmp = line.toLowerCase();
					if(!this.words.containsKey(tmp)) {
						words.put(tmp, new Node(tmp));
					}
				} else {
					//TODO: Debug the ArrayIndexOutOfBoundsException 
					String[] wordsTmp;
					wordsTmp = line.split(" ");
					for(int i = 0; i < line.length() - 1; i++) {
						tmp = wordsTmp[i].toLowerCase();
						if(!this.words.containsKey(tmp)) {
							words.put(tmp, new Node(tmp));
						}
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
	
	public boolean hasFile() {
		return (this.wordFile.exists());
	}
	
	public abstract void generateLadder();
}
