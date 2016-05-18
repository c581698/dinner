package com.hd.helloworld.patterns.decorator;

public abstract class Decorator implements Beverage {

	@Override
	public abstract String desc();

	@Override
	public abstract Double price();

}
