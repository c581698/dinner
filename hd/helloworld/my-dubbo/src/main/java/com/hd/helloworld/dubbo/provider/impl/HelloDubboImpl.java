package com.hd.helloworld.dubbo.provider.impl;

import com.hd.helloworld.dubbo.provider.HelloDubbo;

public class HelloDubboImpl implements HelloDubbo {

	@Override
	public String helloTo(String name) {
		return String.format("Hello %s",name);
	}

}
