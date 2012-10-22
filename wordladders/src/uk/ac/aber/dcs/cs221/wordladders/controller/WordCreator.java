package uk.ac.aber.dcs.cs221.wordladders.controller;

import uk.ac.aber.dcs.cs221.wordladders.model.*;

import java.util.*;
import java.io.*;

public class WordCreator {
	private File wordFile;
	protected Graph<String> graph;
	
	public WordCreator() {
		graph = new Graph<String>();
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
		Hashtable<String, Node<String>> nodeTable = this.graph.getNodes();
		for(String word : nodeTable.keySet()) {
			for(int i = 0; i < word.length(); i++) {
				char[] characters = word.toCharArray();
				for(int j = 97; j < 123; j++) {
					char newChar = (char) j;
					characters[i] = newChar;
					String newWord = new String(characters);
					if(nodeTable.containsKey(newWord) && !word.equals(newWord)) {
						this.graph.addEdge(word, newWord);
					}
				}
			}
		}
	}
	
	public void setFile(String fileName) throws IOException {
		this.wordFile = new File(fileName);
		this.generateWords();
	}
	
	public boolean hasFile() {
		return (this.wordFile.exists());
	}

}
