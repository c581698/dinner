package com.dh.core.security;

public class ValidateCodeException extends Exception {
	public ValidateCodeException() {
	}
	
	public ValidateCodeException(String msg){
		super(msg);
	}
}
