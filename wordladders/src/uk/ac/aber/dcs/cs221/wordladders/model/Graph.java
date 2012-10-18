package uk.ac.aber.dcs.cs221.wordladders.model;

import java.util.*;

public class Graph {
	private Hashtable<String, Node> nodes;
	
	public Graph() {
		this.nodes = new Hashtable<String, Node>();
	}
	
	public void addVertex(String node) {
		if(!this.nodes.containsKey(node)) {
			this.nodes.put(node,new Node(node) );
		} else {
			// throw new error
		}
	}
	
	public void addEdge(String to, String from) {
		if(this.nodes.containsKey(to) && this.nodes.containsKey(from)) {
			Node nodeTo, nodeFrom;
			nodeTo = this.nodes.get(to);
			nodeFrom = this.nodes.get(from);
			nodeTo.addNode(nodeFrom);
			nodeFrom.addNode(nodeTo);
		}
	}
	
	public boolean isConnected(String to, String from) {
		boolean retVal = false;
		if(this.nodes.containsKey(to) && this.nodes.containsKey(from)) {
			Hashtable<String, Node> toConnected = this.nodes.get(to).getConnected();
			if(toConnected.containsKey(from)) {
				retVal = true;
			}
		}
		return retVal;
	}
	
	
	public LinkedList<Node> getNeighbours(String node) {
		LinkedList<Node> retVal = new LinkedList<Node>();
		if(this.nodes.containsKey(node)) {
			for(Node n : this.nodes.get(node).getConnected().values()) {
				retVal.push(n);
			}
		}
		return retVal;
	}
	
	public boolean exists(String node) {
		return this.nodes.containsKey(node);
	}
	
	
}
