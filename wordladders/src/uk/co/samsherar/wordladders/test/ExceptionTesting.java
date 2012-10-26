package uk.co.samsherar.wordladders.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import uk.co.samsherar.wordladders.controller.WordGenerator;
import uk.co.samsherar.wordladders.controller.WordLadderException;

public class ExceptionTesting {
	WordGenerator gen;
	
	@Before
	public void setup() {
		gen = new WordGenerator();
		try {
			gen.setFile("data/testwords.dat");
		} catch(Exception e) {
			fail("testwords file not found");
		}
	}
	
	@Test(expected=IOException.class)
	public void testFailFile() throws IOException {
		gen.setFile("data/rubbish.dat");
	}
	
	@Test
	public void testGenNoLinks() {
		try {
			gen.generateLadder("tree", 2);
		} catch(WordLadderException e) {
			assertEquals(e.getMessage().indexOf("No links"), 0);
		}
	}
	
	@Test
	public void testGenWordNotFound() {
		try {
			gen.generateLadder("asda", 2);
		} catch(WordLadderException e) {
			assertEquals(e.getMessage().indexOf("Word does"), 0);
		}
	}
	
	@Test
	public void testDiscoverLengthError() {
		try {
			gen.discover("head", "speed");
		} catch(WordLadderException e) {
			assertEquals(e.getMessage().indexOf("The two"), 0);
		}
	}
	
	@Test
	public void testDiscoverNoLink() {
		try {
			gen.discover("head", "tree");
		} catch(WordLadderException e) {
			assertEquals(e.getMessage().indexOf("No link"), 0);
			
		}
	}
	
	@Test
	public void testDiscoverNotExist() {
		try {
			gen.discover("head", "xray");
		} catch(WordLadderException e) {
			assertEquals(e.getMessage().indexOf("Either"), 0);
			
		}
	}
}
