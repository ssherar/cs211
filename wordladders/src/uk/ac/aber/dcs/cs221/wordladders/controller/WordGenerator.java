package uk.ac.aber.dcs.cs221.wordladders.controller;

import java.util.*;

import uk.ac.aber.dcs.cs221.wordladders.model.*;

public class WordGenerator extends WordCreator {
	public WordGenerator() {
		
	}
	
	public String[] generateLadder(String word, int steps) {
		//TODO validation
		String[] retVal = new String[steps];
		if(this.graph.exists(word)) {
			LinkedList<Node<String>> genLadder = this.graph.dfs(word);
			for(int i = 0; i < steps; i++) {
				retVal[i] = genLadder.get(i).getValue();
			}
		} else {
			//throw new NodeDoesnotexistException();	
		}
		return retVal;
	}
	
	public LinkedList<String> discover(String startWord, String endWord) {
		Hashtable<String,String> ladder = this.graph.bfs(startWord, endWord);
		LinkedList<String> retVal = new LinkedList<String>();

                retVal.add(endWord);
                String tmp = ladder.get(endWord);
                retVal.add(tmp);
                
                while(!tmp.equals(startWord)) {
                    tmp = ladder.get(tmp);
                    retVal.add(tmp);
                }
                
                Collections.reverse(retVal);
                return retVal;
	}
}
