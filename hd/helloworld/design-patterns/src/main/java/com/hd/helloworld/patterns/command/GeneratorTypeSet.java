package com.hd.helloworld.patterns.command;

public enum GeneratorTypeSet {
	NUMBER_SEQUENCE("Num"),CHARATER_SEQUENCE("Char"),DATE_TIME("DateTime"),STRING("Str");
	
	private String alias;
	private GeneratorTypeSet(String alias) {
		this.alias = alias;
	}
	
	public String getAlias(){
		return this.alias;
	}
}
