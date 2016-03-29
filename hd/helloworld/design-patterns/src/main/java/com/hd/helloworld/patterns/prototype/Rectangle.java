package com.hd.helloworld.patterns.prototype;

public class Rectangle extends Shape {
	
	public Rectangle() {
		this.setType("rectangel");
	}

	@Override
	protected void draw() {
		System.out.println("Drawwing……rectangle");
	}

}
