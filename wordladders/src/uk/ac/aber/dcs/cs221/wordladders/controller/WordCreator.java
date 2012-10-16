package uk.ac.aber.dcs.cs221.wordladders.controller;

import uk.ac.aber.dcs.cs221.wordladders.model.*;

import java.util.*;
import java.io.*;

public class WordCreator {
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
		System.out.println(this.words.size());
	}
	
	public void generateAssociations(String word) {
		for(int i = 0; i < word.length() - 1; i++) {
			char[] characters = word.toCharArray();
			for(int j = 97; j < 123; j++) {
				char newChar = (char) j;
				characters[i] = newChar;
				String tmp = new String(characters);
				if(this.words.containsKey(tmp) && !word.equals(tmp)) {
					System.out.println(tmp);
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
