package uk.ac.aber.dcs.cs221.wordladders.model;

import java.util.*;

public class Node<T> {
	private Hashtable<T, Node<T>> connected;
	private T value;
	private int index;
	
	public Node(T value) {
		this.connected = new Hashtable<T, Node<T>>();
		this.value = value;
		index = 0;
	}
	
	public void addNode(Node<T> node) {
		this.connected.put(node.value, node);
	}
	
	public Hashtable<T, Node<T>> getConnected() {
		return this.connected;
	}
	
	public Node<T> getFirstConnected() {
		return this.connected.get(0);
	}
	
	public Node<T> get(int index) {
		return this.connected.get(index);
	}
	
	public int getSize() {
		return connected.size();
	}
	
	public T getValue() {
		return this.value;
	}
	
	public Node<T> getNext() {
		Node<T> ret = this.connected.get(index);
		index++;
		return ret;
	}
}
