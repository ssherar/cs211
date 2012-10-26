package uk.ac.aber.dcs.cs221.wordladders.test;

import uk.ac.aber.dcs.cs221.wordladders.model.*;

import static org.junit.Assert.*;

import org.junit.*;
import java.util.*;
public class GraphTest {
	
	private Graph<String> graph;
	
	@Before
	public void setup() {
		graph = new Graph<String>();
		graph.addVertex("clock");
		graph.addVertex("click");
		graph.addVertex("flick");
		graph.addEdge("clock", "click");
	}

	@Test
	public void testAddNodes() {
		assertEquals(3, graph.getNodes().size());
		graph.addVertex("flock");
		assertEquals(4, graph.getNodes().size());
	}
	
	@Test
	public void testAddEdge() {
		graph.addEdge("click", "flick");
		LinkedList<Node<String>> clickEdge = graph.getNeighbours("click");
		LinkedList<Node<String>> flickEdge = graph.getNeighbours("flick");
		
		assertEquals(clickEdge.size(), 2);
		assertEquals(flickEdge.size(), 1);
		
		graph.addEdge("clock", "click");
		
		assertEquals(clickEdge.size(), 2);
		assertEquals(flickEdge.size(), 1);
	}
	
	@Test
	public void testGetEdges() {
		LinkedList<Node<String>> clockEdge = graph.getNeighbours("clock");
		LinkedList<Node<String>> clickEdge = graph.getNeighbours("click");
		assertEquals(clockEdge.size(), clickEdge.size());
	}
	
	@Test
	public void testDFS() {
		graph.addEdge("flick", "click");
		
		LinkedList<Node<String>> dfsReturn = graph.dfs("flick");
		assertEquals(dfsReturn.get(0).getValue(), "flick");
		assertEquals(dfsReturn.get(1).getValue(), "click");
		assertEquals(dfsReturn.get(2).getValue(), "clock");
	}
	
	@Test
	public void testBFS() {
		graph.addVertex("clack");
		graph.addEdge("clack", "clock");
		
		graph.addEdge("flick", "click");
		
		graph.addVertex("flack");
		graph.addEdge("flack", "flick");
		
		Hashtable<String, String> bfsReturn = graph.bfs("flack", "clock");
		System.out.println(bfsReturn);
		
		assertEquals("flick", bfsReturn.get("click"));
		assertEquals("flack", bfsReturn.get("flick"));
		assertEquals("click", bfsReturn.get("clock"));
	}

}
