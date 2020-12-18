package com.app.ContactApp.Exception;

public class UserNotFoundException extends Exception {
	public UserNotFoundException() {
		super("User Not Found");
	}
	
	public UserNotFoundException(String msg) {
		super(msg);
	}

}
