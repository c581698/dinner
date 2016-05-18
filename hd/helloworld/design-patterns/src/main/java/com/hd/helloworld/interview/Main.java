package com.hd.helloworld.interview;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;



public class Main {

	public static void main(String[] args) throws ClassNotFoundException, UnsupportedEncodingException {
		 ClassLoader loader = Main.class.getClassLoader(); 
	        while (loader != null) { 
	            System.out.println(loader.toString()); 
	            loader = loader.getParent(); 
	        } 
	}
	
	public static void test(final int i){
		
		Set<Hello> set = new HashSet<Hello>();
		
		Hello h1 = new Hello(10,"zs");
		Hello h2 = new Hello(20,"ls");
		
		set.add(h1);
		set.add(h2);
		
		System.out.println(set.size());
		
		h2.setAge(30);
		
		set.remove(h2);
		
		System.out.println(set.size());
		
		System.out.println(set.contains(h2));
		
		set.add(h2);
		
		System.out.println(set.size());
	}

}

class Hello{
	
	public Hello(int age,String name) {
		this.age = age;
		this.name = name;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private int age;
	private String name;
	
	@Override
	public int hashCode() {
		return this.age * 31 + this.name.hashCode();
	}
	
}