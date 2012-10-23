package uk.ac.aber.dcs.cs221.wordladders.test;
import java.util.Hashtable;

import uk.ac.aber.dcs.cs221.wordladders.model.*;

import static org.junit.Assert.*;

import org.junit.*;

public class NodeTest {
	private Node<String> clock, click, flick;
	private Hashtable<String, Node<String>> ladder;
	
	@Before
	public void setup() {
		ladder = new Hashtable<String, Node<String>>();
		clock = new Node<String>("Clock");
		click = new Node<String>("Click");
		flick = new Node<String>("Flick");
		
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
		assertEquals("", 1, clock.getSize());
		assertEquals("", 1, flick.getSize());
		assertEquals("", 2, click.getSize());
		assertEquals("", 3, ladder.size());
	}
	
	@Test
	public void testadd() {
		Node<String> flock = new Node<String>("Flock");
		ladder.put("Flock", flock);
		flick.addNode(flock);
		flock.addNode(flick);
		clock.addNode(flock);
		flock.addNode(clock);
		
		assertEquals("", 2, flick.getSize());
		assertEquals("", 2, flock.getSize());
		assertEquals("", 4, ladder.size());
	}

}
