package com.epam.exception;

public class ArrayIndexOutOfBound extends Exception{
	
	private static final long serialVersionUID = 315167752217744444L;
	int input;
	public ArrayIndexOutOfBound(int input) {
		this.input = input;
	   }
	   public String toString() {
	      return "Index " + input + " is not found in array list";
	   }

}
