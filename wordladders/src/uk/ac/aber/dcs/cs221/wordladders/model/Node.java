package uk.ac.aber.dcs.cs221.wordladders.model;

public class Node {
	private Node previous;
	private Node next;
	private String value;
	private int weight;
	
	public Node() {
		previous = null;
		next = null;
		value = null;
		weight = 0;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
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
