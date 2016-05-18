package com.hd.helloworld.patterns.test.chain;

import org.junit.Test;

import com.hd.helloworld.patterns.chain.ErrorLog;
import com.hd.helloworld.patterns.chain.ILog;
import com.hd.helloworld.patterns.chain.InfoLog;

public class TestChain {
	@Test
	public void test(){
		ILog info = new InfoLog();
		ILog error = new ErrorLog(info);
		
		info.print(info, "messageeeeeeeeeeee");
		error.print(error, "messageeeeeeeee");
		error.print(info, "messageeeee");
	}
}
