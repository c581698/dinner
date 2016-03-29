package com.hd.helloworld.patterns.builder;
public class ChickenBurger extends Burger {

	@Override
	public String name() {
		return "Chicker Burger";
	}

	@Override
	public float price() {
		return 5f;
	}

}
