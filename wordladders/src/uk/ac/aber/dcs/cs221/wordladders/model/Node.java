package uk.ac.aber.dcs.cs221.wordladders.model;

import java.util.Hashtable;

public class Node {
	private Hashtable<String, Node> connected;
	private String value;
	
	public Node(String value) {
		this.connected = new Hashtable<String, Node>();
		this.value = value;
	}
	
	public void addNode(Node node) {
		this.connected.put(node.value, node);
	}
	
	public Hashtable<String, Node> getConnected() {
		return this.connected;
	}
	
	public int getConnectionsLength() {
		return this.connected.size();
	}
}
