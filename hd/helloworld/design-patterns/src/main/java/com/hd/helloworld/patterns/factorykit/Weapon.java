package com.hd.helloworld.patterns.factorykit;

public abstract class Weapon {
	@Override
	public String toString() {
		return "nothing";
	}
	public String attact(){
		return String.format("WHO DID IT?%s", this.toString());
	}
}
