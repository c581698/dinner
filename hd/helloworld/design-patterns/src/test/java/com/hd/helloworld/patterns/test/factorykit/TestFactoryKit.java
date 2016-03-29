package com.hd.helloworld.patterns.test.factorykit;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.hd.helloworld.patterns.factorykit.Bow;
import com.hd.helloworld.patterns.factorykit.FactoryKit;
import com.hd.helloworld.patterns.factorykit.Weapon;
import com.hd.helloworld.patterns.factorykit.WeaponType;

public class TestFactoryKit {
	@Test
	public void testInst(){
		Weapon weapon = FactoryKit.createInstance(WeaponType.BOW);
		
		assertTrue(weapon instanceof Bow);
		
		System.out.println(weapon.attact());
	}
}
