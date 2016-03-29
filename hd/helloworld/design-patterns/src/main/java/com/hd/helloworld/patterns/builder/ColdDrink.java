package com.hd.helloworld.patterns.builder;

public abstract class ColdDrink implements Item {
	@Override
	public Pack packing() {
		return new Bottle();
	}
}
