package uk.ac.aber.dcs.cs221.wordladders.model;

import java.util.*;

/**
 * The Class Node.
 *
 * @param <T> the generic type for the node and value
 */
public class Node<T> {
	
	/** The connected nodes. */
	private Hashtable<T, Node<T>> connected;
	
	/** The value of the node. */
	private T value;

	/**
	 * Instantiates a new node.
	 *
	 * @param value the value
	 */
	public Node(T value) {
		this.connected = new Hashtable<T, Node<T>>();
		this.value = value;
	}

	/**
	 * Adds the node.
	 *
	 * @param node the node
	 */
	public void addNode(Node<T> node) {
		this.connected.put(node.value, node);
	}

	/**
	 * Gets the connected nodes
	 *
	 * @return the connected nodes
	 */
	public Hashtable<T, Node<T>> getConnected() {
		return this.connected;
	}


	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public int getSize() {
		return connected.size();
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public T getValue() {
		return this.value;
	}
}