package com.dh.core.security;

public class MethodErrorException extends Exception {
	public MethodErrorException() {
	}
	
	public MethodErrorException(String msg){
		super(msg);
	}
}
