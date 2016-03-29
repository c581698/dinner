package com.hd.helloworld.patterns.filter;

public class NumberFilter implements Filter {

	@Override
	public void doFilter(String text,FilterChain chain) {
		chain.doFilter(text.replaceAll("\\d", ""));
	}

}
