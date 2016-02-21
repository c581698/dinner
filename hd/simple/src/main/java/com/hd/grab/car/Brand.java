package com.hd.grab.car;

import java.io.IOException;
import java.util.Arrays;

import com.google.gson.annotations.Expose;

public class Brand{
	@Expose
	Long id;
	@Expose
	String name;
	
	public boolean before(){
		return true;
	}

	public void after(Object...obj){
		try {
			Main.buildMarker(id);
			
			Main.LOG.info("--------------------------");
			Main.LOG.info("--------------------------");
		} catch (IOException e) {
			Main.LOG.info("************---- BRAND:"+id);
			e.printStackTrace();
		}
	}
	
	public Brand() {
	}

	public Brand(Long id,String name) {
		this.id = id;
		this.name = name;
	}
	
	public String toSql(Object...strings){
		return String.format(this.getTemplate(), getValues(strings));
	}
	
	String getValues(Object...strings){
		String[] sqlData = new String[]{this.id.toString(),"'"+this.name+"'"};
		
		return Arrays.toString(sqlData).replace("[","").replace("]", "");
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTemplate() {
		return "insert into car_brand(id,name) values(%s);";
	}
}