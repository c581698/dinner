package com.hd.helloworld.patterns.decorator;

public class ABean implements Beverage {
	private String desc = "A类咖啡豆";
	
	@Override
	public String desc() {
		return desc;
	}

	@Override
	public Double price() {
		return 40d;
	}

}
