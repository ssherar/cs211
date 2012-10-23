package uk.ac.aber.dcs.cs221.wordladders.controller;

import java.util.*;

import uk.ac.aber.dcs.cs221.wordladders.model.*;

public class WordGenerator extends WordCreator {
	public WordGenerator() {
		
	}
	
	public String[] generateLadder(String word, int steps) throws WordLadderException{
		//TODO validation
		String[] retVal;
		if(this.graph.exists(word)) {
			LinkedList<Node<String>> genLadder = this.graph.dfs(word);
			retVal = new String[genLadder.size()];
			for(int i = 0; i < genLadder.size(); i++) {
				retVal[i] = genLadder.get(i).getValue();
			}
		} else {
			throw new WordLadderException("Word does not exist in the dictionary file");	
		}
		return retVal;
	}
	
	public LinkedList<String> discover(String startWord, String endWord) throws WordLadderException {
		LinkedList<String> retVal = null;
		if(startWord.length() == endWord.length()) {
			Hashtable<String,String> ladder = this.graph.bfs(startWord, endWord);
			if(ladder.containsKey(endWord)) {
				retVal = new LinkedList<String>();
		
				retVal.add(endWord);
				String tmp = ladder.get(endWord);
				retVal.add(tmp);
		
				while(!tmp.equals(startWord)) {
					tmp = ladder.get(tmp);
					retVal.add(tmp);
				}
		
				Collections.reverse(retVal);
			} else {
				throw new WordLadderException("No link can be found between " + startWord + " and " + endWord);
			}
		} else {
			throw new WordLadderException("The two words are not the same length");
		}
		return retVal;
	}
}
