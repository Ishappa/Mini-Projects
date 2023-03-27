package com.icici;

public class InvalidChoiceException extends RuntimeException
{
	private String message;
	
	InvalidChoiceException(String message){
		this.message=message;
	}
	
	public String getMessage() {
		return message;
	}
}
