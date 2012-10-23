package uk.ac.aber.dcs.cs221.wordladders.controller;

import uk.ac.aber.dcs.cs221.wordladders.model.*;

import java.util.*;
import java.io.*;

/**
 * The Class WordCreator. This handles all the
 * gritty data manipulation and creating associations, and
 * handling file sanitation and also parsing.
 */
public class WordCreator {
	
	/** The word file. */
	private File wordFile;
	
	/** The graph. */
	protected Graph<String> graph;
	
	/**
	 * Instantiates a new word creator.
	 */
	public WordCreator() {
		graph = new Graph<String>();
		this.wordFile = null;
	}
	
	/**
	 * Generate words by taking words out of a file
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void generateWords() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(wordFile));
		for(String line; (line = br.readLine()) != null;) {
			// If there is anything on this line
			if(line.length() > 1) {
				String tmp;
				// Regex to replace all punctuation with nothing.
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
	
	/**
	 * Generate associations between nodes, by changing one
	 * letter at a time, and checking if there is the key exists
	 */
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
	
	/**
	 * Sets the file and generates the words
	 *
	 * @param fileName the new file
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see WordCreator#generateWords()
	 */
	public void setFile(String fileName) throws IOException {
		this.wordFile = new File(fileName);
		this.generateWords();
	}
	
	/**
	 * Checks if we have a file which exists
	 * on the file system
	 *
	 * @return true, if successful
	 */
	public boolean hasFile() {
		return (this.wordFile.exists());
	}

}
