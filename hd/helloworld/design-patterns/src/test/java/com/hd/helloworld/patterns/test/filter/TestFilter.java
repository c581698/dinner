package com.hd.helloworld.patterns.test.filter;

import org.junit.Test;
import static org.junit.Assert.*;

import com.hd.helloworld.patterns.filter.FilterChain;
import com.hd.helloworld.patterns.filter.LetterFilter;
import com.hd.helloworld.patterns.filter.NumberFilter;

public class TestFilter {
	@Test
	public void test(){
		FilterChain chain = new FilterChain();
		String text = "asf9^&*^5234kjha(987";
		
		chain.addFilter(new LetterFilter());
		chain.addFilter(new NumberFilter());
		
		chain.doFilter(text);
		
		assertEquals("^&*^(", chain.result);
	}
}
