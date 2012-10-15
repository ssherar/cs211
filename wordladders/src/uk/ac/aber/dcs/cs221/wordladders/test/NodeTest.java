package uk.ac.aber.dcs.cs221.wordladders.test;
import java.util.Hashtable;

import uk.ac.aber.dcs.cs221.wordladders.model.*;

import static org.junit.Assert.*;

import org.junit.*;

public class NodeTest {
	private Node clock, click, flick;
	private Hashtable<String, Node> ladder;
	
	@Before
	public void setup() {
		ladder = new Hashtable<String, Node>();
		clock = new Node("Clock");
		click = new Node("Click");
		flick = new Node("Flick");
		
		ladder.put("Clock", clock);
		ladder.put("Click", click);
		ladder.put("Flick", flick);
		
		clock.addNode(click);
		click.addNode(clock);
		
		click.addNode(flick);
		flick.addNode(click);
	}
	
	@Test
	public void testSizes() {
		assertEquals("", 1, clock.getConnectionsLength());
		assertEquals("", 1, flick.getConnectionsLength());
		assertEquals("", 2, click.getConnectionsLength());
		assertEquals("", 3, ladder.size());
	}
	
	@Test
	public void testadd() {
		Node flock = new Node("Flock");
		ladder.put("Flock", flock);
		flick.addNode(flock);
		flock.addNode(flick);
		clock.addNode(flock);
		flock.addNode(clock);
		
		assertEquals("", 2, flick.getConnectionsLength());
		assertEquals("", 2, flock.getConnectionsLength());
		assertEquals("", 4, ladder.size());
	}

}
