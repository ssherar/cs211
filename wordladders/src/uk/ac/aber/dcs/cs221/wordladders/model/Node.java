package uk.ac.aber.dcs.cs221.wordladders.model;

import java.util.ArrayList;

public class Node {
	private ArrayList<Node> next;
	private String value;
	private int weight;
	
	public Node() {
		next = new ArrayList<Node>();
		value = null;
		weight = 0;
	}


	public ArrayList<Node> getNext() {
		return next;
	}

	public void setNext(ArrayList<Node> next) {
		this.next = next;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
}
