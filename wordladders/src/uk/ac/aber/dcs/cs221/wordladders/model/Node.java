package uk.ac.aber.dcs.cs221.wordladders.model;

import java.util.*;

public class Node {
	private Hashtable<String, Node> connected;
	private String value;
	private int index;
	
	public Node(String value) {
		this.connected = new Hashtable<String, Node>();
		this.value = value;
		index = 0;
	}
	
	public void addNode(Node node) {
		this.connected.put(node.value, node);
	}
	
	public Hashtable<String, Node> getConnected() {
		return this.connected;
	}
	
	public Node getFirstConnected() {
		return this.connected.get(0);
	}
	
	public Node get(int index) {
		return this.connected.get(index);
	}
	
	public int getSize() {
		return connected.size();
	}
	
	public String getValue() {
		return this.value;
	}
	
	public Node getNext() {
		Node ret = this.connected.get(index);
		index++;
		return ret;
	}
}
