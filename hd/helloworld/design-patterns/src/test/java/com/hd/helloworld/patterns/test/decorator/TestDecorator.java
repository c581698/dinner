package com.hd.helloworld.patterns.test.decorator;

import org.junit.Test;

import com.hd.helloworld.patterns.decorator.ABean;
import com.hd.helloworld.patterns.decorator.Beverage;
import com.hd.helloworld.patterns.decorator.MilkCoffee;

public class TestDecorator {
	@Test
	public void test() {
		Beverage milk = new MilkCoffee(new ABean());
		
		System.out.println(milk.desc());
		
		
	}
}
