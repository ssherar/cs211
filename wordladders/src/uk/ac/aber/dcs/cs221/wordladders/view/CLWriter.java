package uk.ac.aber.dcs.cs221.wordladders.view;

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
	* Read an Int from the users input
	* @param	null
	* @return	The integer, or Int.MIN_VALUE otherwise
	*/
    public int readInt() {
        try { 
            return (int)input.nextInt();
        } catch(Exception e) {
            
        }
        return Integer.MIN_VALUE;
    }
    
	/**
	* Read in a string of a certain length
	* @param	length	Length of the string
	* @return	String or nothing otherwise
	*/
    public String readString(int length) {
        try {
        	String ret = "";
        	if(length > 0) {
        		ret = new String(input.next().substring(0,length -1));
        	} else {
        		ret = new String(input.next());
        	}
        	return ret;
        } catch (Exception e) {
            
        }
        return "";
    }
    
    public String readString() {
    	return this.readString(-1);
    }
    
}
