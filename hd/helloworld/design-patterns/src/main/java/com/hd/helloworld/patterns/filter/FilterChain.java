package com.hd.helloworld.patterns.filter;

import java.util.ArrayList;
import java.util.List;
/**
 * 过滤器模式（Filter Pattern）或标准模式（Criteria Pattern）是一种设计模式，这种模式允许开发人员使用不同的标准来过滤一组对象，通过逻辑运算以解耦的方式把它们连接起来。这种类型的设计模式属于结构型模式，它结合多个标准来获得单一标准
* @ClassName: FilterChain
* @Description: TODO
* @author chs cyj91516@aliyun.com
* @date 2016年5月18日 下午4:03:47
*
 */
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
