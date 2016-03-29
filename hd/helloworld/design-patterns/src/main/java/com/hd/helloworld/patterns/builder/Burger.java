package com.hd.helloworld.patterns.builder;
public abstract class Burger implements Item {
	@Override
	public Pack packing() {
		return new Wrapper();
	}
}
