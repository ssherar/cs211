package uk.co.samsherar.wordladders.test;
import java.util.Hashtable;

import uk.co.samsherar.wordladders.model.*;

import static org.junit.Assert.*;

import org.junit.*;

public class NodeTest {
	

	private Node<String> clock, click, flick, newFlick, newClock;
	
	private Hashtable<String, Node<String>> ladder;

	@Before
	public void setup() {
		ladder = new Hashtable<String, Node<String>>();
		clock = new Node<String>("clock");
		click = new Node<String>("click");
		flick = new Node<String>("flick");
		
		ladder.put("Clock", clock);
		ladder.put("Click", click);
		ladder.put("Flick", flick);
		
		clock.addNode(click);
		click.addNode(clock);
		
		click.addNode(flick);
		flick.addNode(click);
		
		newFlick = click.getConnected().get("flick");
		newClock = click.getConnected().get("clock");
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
	
	@Test
	public void testGetValue() {
		assertEquals("flick", flick.getValue());
		assertEquals("clock", clock.getValue());
		assertEquals("click", click.getValue());
	}
	
	@Test
	public void testMemoryAddresses() {		
		assertEquals(newFlick, flick);
		assertEquals(newClock, clock);
	}
	
	@Test
	public void testEquals() {
		assertEquals(newFlick.getValue(), flick.getValue());
		assertEquals(newClock.getValue(), clock.getValue());
		
		assertEquals(newFlick.getConnected(), flick.getConnected());
		assertEquals(newClock.getConnected(), clock.getConnected());
	}
	

}
