package uk.ac.aber.dcs.cs221.wordladders.controller;

import uk.ac.aber.dcs.cs221.wordladders.model.*;

public class WordGenerator extends WordCreator {
	public WordGenerator() {
		
	}
	
	public String[] generateLadder(String word, int steps) {
		String[] retVal = new String[steps];
		this.generateAssociations();
		Node wordNode = this.words.get(word);
		retVal[0] = wordNode.getValue();
		for(int i = 0; i < steps; i++) {
			Node tmp;
			for(int j = 0; j < wordNode.getSize(); j++) {
				tmp = wordNode.getNext();
				boolean added = false;
				for(int k = 0; k < steps; k++) {
					if(!retVal[k].equals(tmp.getValue())) {
						added = true;
						retVal[i] = tmp.getValue();
						break;
					}
				}
				if(added == true) {
					wordNode = tmp;
					break;
				}
				
			}
			tmp  = wordNode.getNext();
		}
		return retVal;
	}

}
