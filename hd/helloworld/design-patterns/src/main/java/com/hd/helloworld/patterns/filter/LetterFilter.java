package com.hd.helloworld.patterns.filter;


public class LetterFilter implements Filter {
	@Override
	public void doFilter(String text,FilterChain chain) {
		chain.doFilter(text.replaceAll("[a-zA-Z]", ""));
	}
}
