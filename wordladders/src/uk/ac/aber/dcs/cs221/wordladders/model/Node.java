package uk.ac.aber.dcs.cs221.wordladders.model;

import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Node.
 *
 * @param <T> the generic type
 */
public class Node<T> {
	
	/** The connected. */
	private Hashtable<T, Node<T>> connected;
	
	/** The value. */
	private T value;
	
	/** The index. */
	private int index;

	/**
	 * Instantiates a new node.
	 *
	 * @param value the value
	 */
	public Node(T value) {
		this.connected = new Hashtable<T, Node<T>>();
		this.value = value;
		index = 0;
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
	 * Gets the connected.
	 *
	 * @return the connected
	 */
	public Hashtable<T, Node<T>> getConnected() {
		return this.connected;
	}

	/**
	 * Gets the first connected.
	 *
	 * @return the first connected
	 */
	public Node<T> getFirstConnected() {
		return this.connected.get(0);
	}

	/**
	 * Gets the.
	 *
	 * @param index the index
	 * @return the node
	 */
	public Node<T> get(int index) {
		return this.connected.get(index);
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

	/**
	 * Gets the next.
	 *
	 * @return the next
	 */
	public Node<T> getNext() {
		Node<T> ret = this.connected.get(index);
		index++;
		return ret;
	}
}