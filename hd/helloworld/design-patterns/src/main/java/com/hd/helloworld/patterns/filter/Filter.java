package com.hd.helloworld.patterns.filter;

public interface Filter {
	public void doFilter(String text,FilterChain chains);
}
