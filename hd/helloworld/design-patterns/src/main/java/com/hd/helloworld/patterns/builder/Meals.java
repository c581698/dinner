package com.hd.helloworld.patterns.builder;

import java.util.ArrayList;
import java.util.List;

public class Meals {
	private List<Item> items = new ArrayList<Item>();
	
	public void addItem(Item item){
		items.add(item);
	}

    public float price(){
       float amount = 0;
       
       for(Item item: items){
    	   amount += item.price();
       }
       
       return amount;
    }

    public static Meals prepareVegBurger(){
    	Meals meals = new Meals();
    	
    	meals.addItem(new VegBurger());
    	meals.addItem(new Coke());
    	
    	return meals;
    }
    
    public static Meals prepareChickenBuger(){
    	Meals meals = new Meals();
    	
    	meals.addItem(new ChickenBurger());
    	meals.addItem(new Pepsi());
    	
    	return meals;
    }
}
