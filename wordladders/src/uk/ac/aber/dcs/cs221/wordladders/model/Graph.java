package uk.ac.aber.dcs.cs221.wordladders.model;

import java.util.*;

public class Graph<K> {
	private Hashtable<K, Node<K>> nodes;
	
	public Graph() {
		this.nodes = new Hashtable<K, Node<K>>();
	}
	
	public void addVertex(K node) {
		if(!this.nodes.containsKey(node)) {
			this.nodes.put(node,new Node<K>(node) );
		} else {
			// throw new error
		}
	}
	
	public void addEdge(String to, String from) {
		if(this.nodes.containsKey(to) && this.nodes.containsKey(from)) {
			Node<K> nodeTo, nodeFrom;
			nodeTo = this.nodes.get(to);
			nodeFrom = this.nodes.get(from);
			nodeTo.addNode(nodeFrom);
			nodeFrom.addNode(nodeTo);
		}
	}
	
	public boolean isConnected(K to, K from) {
		boolean retVal = false;
		if(this.nodes.containsKey(to) && this.nodes.containsKey(from)) {
			Hashtable<K, Node<K>> toConnected = this.nodes.get(to).getConnected();
			if(toConnected.containsKey(from)) {
				retVal = true;
			}
		}
		return retVal;
	}
	
	
	public LinkedList<Node<K>> getNeighbours(K node) {
		LinkedList<Node<K>> retVal = new LinkedList<Node<K>>();
		if(this.nodes.containsKey(node)) {
			for(Node<K> n : this.nodes.get(node).getConnected().values()) {
				retVal.push(n);
			}
		}
		return retVal;
	}
	
	public Node<K> getParentNode(String node) {
		Node<K> retVal;
		if(this.nodes.containsKey(node)) {
			retVal = this.nodes.get(node);
		} else {
			retVal = null;
		}
		return retVal;
	}
	
	public boolean exists(String node) {
		return this.nodes.containsKey(node);
	}
	
	public Hashtable<K, Node<K>> getNodes() {
		return this.nodes;
	}
	
	public LinkedList<Node<K>> dfs(String node) {
		LinkedList<Node<K>> linkedNodes = new LinkedList<Node<K>>();
		if(this.nodes.containsKey(node)) {
			
			dfs(this.nodes.get(node), linkedNodes);
		}
		return linkedNodes;
	}
	
	public void dfs(Node<K> node, LinkedList<Node<K>> linkedNodes) {
		linkedNodes.add(node);
		for(Node<K> n : getNeighbours(node.getValue())) {
			if(!linkedNodes.contains(n)) {
				dfs(n, linkedNodes);
			}
		}
	}

}
