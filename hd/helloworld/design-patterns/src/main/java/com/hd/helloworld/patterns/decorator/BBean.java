package com.hd.helloworld.patterns.decorator;

public class BBean implements Beverage {
	private String desc="B 类咖啡豆";
	@Override
	public String desc() {
		return desc;
	}

	@Override
	public Double price() {
		return 50d;
	}

}
