package uk.ac.aber.dcs.cs221.wordladders.controller;

import uk.ac.aber.dcs.cs221.wordladders.model.*;

import java.util.*;
import java.io.*;

public class WordCreator {
	private File wordFile;
	protected Graph graph;;
	
	public WordCreator() {
		graph = new Graph();
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
					if(!this.graph.exists(tmp)) {
						this.graph.addVertex(tmp);
					}
				} else {
					//TODO: Debug the ArrayIndexOutOfBoundsException 
					String[] wordsTmp;
					wordsTmp = line.split(" ");
					for(int i = 0; i < line.length() - 1; i++) {
						tmp = wordsTmp[i].toLowerCase();
						if(!this.graph.exists(tmp)) {
							this.graph.addVertex(tmp);
						}
					}
				}
			}
			
		}
		br.close();
	}
	
	public void generateAssociations() {
		/*for(String word : this.words.keySet()) {
			for(int i = 0; i < word.length(); i++) {
				char[] character = word.toCharArray();
				for(int j = 97; j < 123; j++) {
					char newChar = (char) j;
					character[i] = newChar;
					String tmp = new String(character);
					if(this.words.containsKey(tmp) && !word.equals(tmp)) {
						Node to, from;
						to = this.words.get(tmp);
						from  = this.words.get(word);
						to.addNode(from);
						from.addNode(to);
					}
				}
			}
		}*/
		
		for(String word : )
	}
	
	public void setFile(String fileName) throws IOException {
		this.wordFile = new File(fileName);
		this.generateWords();
	}
	
	public boolean hasFile() {
		return (this.wordFile.exists());
	}
}
