package com.hd.helloworld.patterns.facade;

public class SubSysB implements Sys {

	@Override
	public void exec() {
		System.out.println("SubSysB is starting……");
	}

}
