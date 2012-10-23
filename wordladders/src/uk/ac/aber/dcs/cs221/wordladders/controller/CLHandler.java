package uk.ac.aber.dcs.cs221.wordladders.controller;

import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class CLHandler.
 */
public class CLHandler {
	
	/** Javas input class. */
    private Scanner input;

	/**
	 * Constructor for the class which only serves as a
	 * initialiser for input
	 *
	 */
    public CLHandler() {
        input = new Scanner(System.in);
    }
    
	/**
	 * Read an Integer from the users input.
	 *
	 * @return The integer, or Int.MIN_VALUE otherwise
	 */
    public int readInt() {
    	int retVal;
        try { 
            retVal = input.nextInt();
        } catch(Exception e) {
            retVal = Integer.MIN_VALUE;
        }
        return retVal;
    }
    
	/**
	 * Read in a string of a certain length.
	 *
	 * @param length Length of the string
	 * @return String or nothing otherwise
	 */
    public String readString(int length) {
    	String retVal;
        try {
        	if(length > 0) {
        		retVal = new String(input.next().substring(0,length -1));
        	} else {
        		retVal = new String(input.next());
        	}
        } catch (Exception e) {
        	retVal = "";
        }
        return retVal;
    }
    
    /**
     * Read a string with no variable length.
     *
     * @see CLHandler#readString(length)
     * @return the string
     */
    public String readString() {
    	return this.readString(-1);
    }
    
    /**
     * Write to the commandline.
     *
     * @param line the line
     */
    public void write(String line) {
    	System.out.println(line);
    }
    
    /**
     * Write to a new line character to the command line.
     * @see CLHander#readString(line)
     */
    public void write() {
    	this.write("");
    }
    
    /**
     * Write a line to the command line without a new line
     * character at the end.
     *
     * @param line the line
     */
    public void prompt(String line) {
    	System.out.print(line);
    }
}
