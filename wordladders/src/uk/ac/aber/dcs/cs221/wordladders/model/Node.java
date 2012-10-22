package uk.ac.aber.dcs.cs221.wordladders.model;

import java.util.*;

public class Node<T> {
	private Hashtable<T, Node<T>> connected;
	private T value;
	
	public Node(T value) {
		this.connected = new Hashtable<T, Node<T>>();
	}
	
	public void addNode(Node<T> node) {
		this.connected.put(node.value, node);
	}
	
	public Hashtable<T, Node<T>> getConnected() {
		return this.connected;
	}
	
	public int getSize() {
		return connected.size();
	}
	
	public T getValue() {
		return this.value;
	}
	
}
