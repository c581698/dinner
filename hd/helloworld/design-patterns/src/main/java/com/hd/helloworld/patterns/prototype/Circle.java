package com.hd.helloworld.patterns.prototype;

public class Circle extends Shape {
	
	public Circle() {
		this.setType("circle");
	}

	@Override
	protected void draw() {
		System.out.println("Drawwing……circle");
	}
}
