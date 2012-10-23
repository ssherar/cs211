package uk.ac.aber.dcs.cs221.wordladders.controller;

import java.util.*;

import uk.ac.aber.dcs.cs221.wordladders.model.*;

public class WordGenerator extends WordCreator {
	public WordGenerator() {
		
	}
	
	public LinkedList<String> generateLadder(String word, int steps) throws WordLadderException{
		//TODO validation
		LinkedList<String> retVal = new LinkedList<String>();
		if(this.graph.exists(word)) {
			LinkedList<Node<String>> genLadder = this.graph.dfs(word);
			int min = Math.min(steps, genLadder.size());
			for(int i = 0; i < min; i++) {
				retVal.add(genLadder.get(i).getValue());
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
			if(this.graph.exists(startWord) && this.graph.exists(endWord)) {
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
					throw new WordLadderException("Either " + startWord + " or " + endWord + " do not exist in the dictionary");
				}
			} else {
				throw new WordLadderException("No link can be found between " + startWord + " and " + endWord);
			}
		} else {
			throw new WordLadderException("The two words are not the same length");
		}
		return retVal;
	}
}
