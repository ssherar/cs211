package uk.ac.aber.dcs.cs221.wordladders.model;

import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Graph. This data structure holds all the nodes in
 * a hashtable, which can be type defined by the user on instantiation using
 * java generics.
 *
 * @param <K> the type for the nodes.
 */
public class Graph<K> {
	
	/** The nodes. */
	private Hashtable<K, Node<K>> nodes;
	
	/**
	 * Instantiates a new graph.
	 */
	public Graph() {
		this.nodes = new Hashtable<K, Node<K>>();
	}
	
	/**
	 * Adds the vertex to the graph, while
	 * making sure that we don't have any duplicates are ommitted.
	 *
	 * @param node the node
	 */
	public void addVertex(K node) {
		if(!this.nodes.containsKey(node)) {
			this.nodes.put(node,new Node<K>(node) );
		}
	}
	
	/**
	 * Adds an "edge" or a connection between two different nodes
	 *
	 * @param to the node to
	 * @param from the node from
	 */
	public void addEdge(K to, K from) {
		if(this.nodes.containsKey(to) && this.nodes.containsKey(from)) {
			Node<K> nodeTo, nodeFrom;
			nodeTo = this.nodes.get(to);
			nodeFrom = this.nodes.get(from);
			nodeTo.addNode(nodeFrom);
			nodeFrom.addNode(nodeTo);
		}
	}
	
	/**
	 * Checks if two nodes are connected
	 *
	 * @param to the node to
	 * @param from the node from
	 * @return true, if is connected
	 */
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
	
	
	/**
	 * Gets the neighbours of a certain vertex
	 *
	 * @param node the node
	 * @return the neighbours
	 */
	public LinkedList<Node<K>> getNeighbours(K node) {
		LinkedList<Node<K>> retVal = new LinkedList<Node<K>>();
		if(this.nodes.containsKey(node)) {
			for(Node<K> n : this.nodes.get(node).getConnected().values()) {
				retVal.push(n);
			}
		}
		return retVal;
	}
	
	/**
	 * Gets the parent node from a key which has
	 * been passed in
	 *
	 * @param node the node
	 * @return the parent node
	 */
	public Node<K> getParentNode(K node) {
		Node<K> retVal;
		if(this.nodes.containsKey(node)) {
			retVal = this.nodes.get(node);
		} else {
			retVal = null;
		}
		return retVal;
	}
	
	/**
	 * Check if a certain key exists in the 
	 * hashtable
	 *
	 * @param node the node
	 * @return true, if successful
	 */
	public boolean exists(K node) {
		return this.nodes.containsKey(node);
	}
	
	/**
	 * Gets the hashtable of nodes and returns
	 *
	 * @return the nodes
	 */
	public Hashtable<K, Node<K>> getNodes() {
		return this.nodes;
	}
	
	/**
	 * Depth First Search. Used for finding the connected nodes by
	 * looking down the left hand side of the graph first.<br />
	 * 
	 * This is only a container to the real method.
	 *
	 * @param node the node
	 * @return the linked list
	 * @see Graph#dfs(node, list)
	 */
	public LinkedList<Node<K>> dfs(K node) {
		LinkedList<Node<K>> linkedNodes = new LinkedList<Node<K>>();
		if(this.nodes.containsKey(node)) {
			
			dfs(this.nodes.get(node), linkedNodes);
		}
		return linkedNodes;
	}
	
	/**
	 * Depth First Search, the recursive method which looks at
	 * each node from the bottom left to the top right nodes
	 * respectfully.
	 *
	 * @param node the node
	 * @param linkedNodes the linked nodes
	 */
	public void dfs(Node<K> node, LinkedList<Node<K>> linkedNodes) {
		linkedNodes.add(node);
		for(Node<K> n : getNeighbours(node.getValue())) {
			if(!linkedNodes.contains(n)) {
				dfs(n, linkedNodes);
			}
		}
	}
	
	/**
	 * Breadth First Search. Used for finding the shortest path between
	 * two nodes. This method only checks if the nodes exist in the hashtable
	 * saving us lots of calculations
	 *
	 * @param startNode the start node
	 * @param endNode the end node
	 * @return the hashtable
	 * @see Graph#bfs(node, endNode)
	 */
	public Hashtable<K,K> bfs(K startNode, K endNode) {
		if(this.nodes.containsKey(startNode) && this.nodes.containsKey(endNode)) {
			return this.bfs(this.nodes.get(startNode), this.nodes.get(endNode));
		} else {
			return null;
		}
	}
	
	/**
	 * Bfs.
	 *
	 * @param node the node
	 * @param endNode the end node
	 * @return the hashtable
	 */
	public Hashtable<K, K> bfs(Node<K> node, Node<K> endNode) {
		Hashtable<K,K> predecessor = new Hashtable<K,K>();
		Queue<Node<K>> q = new LinkedList<Node<K>>();
		Node<K> currentNode;
		Set<Node<K>> visited = new HashSet<Node<K>>();
                
		q.add(node);
		visited.add(node);
		
		while(!q.isEmpty()) {
			currentNode = q.remove();
			if(currentNode.equals(endNode)) {
				break;
			} else {
				for(Node<K> nextNode : getNeighbours(currentNode.getValue())) {
					if(!visited.contains(nextNode)) {
						q.add(nextNode);
						visited.add(nextNode);
                        predecessor.put(nextNode.getValue(), currentNode.getValue());
					}
				}
			}
			
		}
		return predecessor;
	}
}
