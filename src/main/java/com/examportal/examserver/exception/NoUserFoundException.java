package com.examportal.examserver.exception;

public class NoUserFoundException extends Exception {
	
	public NoUserFoundException()
	{
		
	}
	
	public NoUserFoundException(String msg)
	{
		super(msg);
	}
}
