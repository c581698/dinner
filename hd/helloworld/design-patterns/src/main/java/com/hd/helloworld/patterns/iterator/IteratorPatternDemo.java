package com.hd.helloworld.patterns.iterator;

public class IteratorPatternDemo {
	public static void main(String[] args) {
		Container container = new NameRepository();
		
		for(Iterator it = container.getIterator();it.hasNext();){
			System.out.println("Name:"+it.next());
		}
	}
}
