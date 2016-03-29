package com.hd.helloworld.patterns.test.abstractfactory;

import org.junit.Test;

import static org.junit.Assert.*;

import com.hd.helloworld.patterns.abstractfactory.ElfKingdomFactory;
import com.hd.helloworld.patterns.abstractfactory.KingdomFactory;

public class TestAbstractFactory {
	@Test
	public void testInst(){
		KingdomFactory factory = new ElfKingdomFactory();
		
		assertTrue(factory instanceof ElfKingdomFactory);
		
		System.out.println(factory.createKing().toString());
		System.out.println(factory.createArmy().toString());
		System.out.println(factory.createCastle().toString());
	}
}
