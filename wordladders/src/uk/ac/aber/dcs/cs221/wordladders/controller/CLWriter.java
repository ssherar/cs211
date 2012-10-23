package uk.ac.aber.dcs.cs221.wordladders.controller;

import java.util.*;

public class CLWriter {
	/**
	* Javas input class
	*/
    private Scanner input;

	/**
	* Constructor for the class
	* @param	null
	*/
    public CLWriter() {
        input = new Scanner(System.in);
    }
    
	/**
	* Read an Integer from the users input
	* @param	null
	* @return	The integer, or Int.MIN_VALUE otherwise
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
	* Read in a string of a certain length
	* @param	length	Length of the string
	* @return	String or nothing otherwise
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
    
    public String readString() {
    	return this.readString(-1);
    }
    
    public void write(String line) {
    	System.out.println(line);
    }
    
    public void write() {
    	this.write("");
    }
    
    public void prompt(String line) {
    	System.out.print(line);
    }
    
}
