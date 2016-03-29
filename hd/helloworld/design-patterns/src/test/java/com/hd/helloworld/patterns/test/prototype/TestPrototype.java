package com.hd.helloworld.patterns.test.prototype;

import org.junit.Test;

import com.hd.helloworld.patterns.prototype.Shape;
import com.hd.helloworld.patterns.prototype.ShapeCache;

import static org.junit.Assert.*;

public class TestPrototype {
	@Test
	public void test(){
		ShapeCache.load();
		
		Shape shape1 = ShapeCache.get("circle");
		Shape shape2 = ShapeCache.get("circle");
		
		assertTrue(shape1 != shape2);
		assertTrue(shape1.getClass() == shape2.getClass());
		assertTrue(shape1.equals(shape2));
	}
}
