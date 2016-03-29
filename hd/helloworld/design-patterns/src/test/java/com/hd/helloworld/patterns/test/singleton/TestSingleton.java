package com.hd.helloworld.patterns.test.singleton;

import org.junit.Assert;
import org.junit.Test;

import com.hd.helloworld.patterns.singleton.SingletonInst;

public class TestSingleton {
	@Test
	public void testInst(){
		SingletonInst inst1 = SingletonInst.getInstance();
		SingletonInst inst2 = SingletonInst.getInstance();
		
		Assert.assertEquals(inst1, inst2);
	}
}
