package com.hd.helloworld.patterns.flyweight;

import java.util.HashMap;
import java.util.Map;

public class Factory {
	private static final Map<String, Circle> circles = new HashMap<String, Circle>();
	
	public static Circle getCircle(String color){
		Circle circle = circles.get(color);
		
		if(circle == null){
			circle = new Circle(color);
			circles.put(color, circle);
		}
		
		return circle;
	}
}
