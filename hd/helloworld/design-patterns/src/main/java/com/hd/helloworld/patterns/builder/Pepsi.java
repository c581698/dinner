package com.hd.helloworld.patterns.builder;
public class Pepsi extends ColdDrink {

	@Override
	public String name() {
		return "Pepsi";
	}

	@Override
	public float price() {
		return 2;
	}

}
