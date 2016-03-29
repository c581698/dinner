package com.hd.helloworld.patterns.filter;

import java.util.ArrayList;
import java.util.List;

public class FilterChain {
	private List<Filter> filters = new ArrayList<Filter>();
	private int index = -1;
	public String result;
	
	public void addFilter(Filter filter){
		if(null != filter)
			filters.add(filter);
	}
	public void doFilter(String text){
		result = text;
		
		if(filters.size()-1 > index && null != text)
			filters.get(++index).doFilter(text,this);
	}
}
