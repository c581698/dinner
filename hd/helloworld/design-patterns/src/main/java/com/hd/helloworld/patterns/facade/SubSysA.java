package com.hd.helloworld.patterns.facade;

public class SubSysA implements Sys {

	@Override
	public void exec() {
		System.out.println("SubSysA is starting……");
	}

}
