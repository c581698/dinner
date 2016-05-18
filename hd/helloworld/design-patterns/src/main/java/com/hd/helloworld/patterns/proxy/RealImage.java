package com.hd.helloworld.patterns.proxy;

public class RealImage implements Image {
	private String filePath;
	
	public RealImage(String filePath){
		this.filePath = filePath;
		loadImg();
	}
	
	public void loadImg() {
		System.out.println("loading image:"+filePath);
	}

	@Override
	public void display() {
		System.out.println("display image:"+filePath);
	}

}
