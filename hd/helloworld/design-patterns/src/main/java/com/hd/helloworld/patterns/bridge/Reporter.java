package com.hd.helloworld.patterns.bridge;


public abstract class Reporter {
	protected String header="";
	protected String trailer="";
	protected String report="";
	
	public Reporter() {
		Report.register(this);
	}
	
	public abstract void addLine(String line);
	
	public void setHeader(String header){
		this.header = header;
	}
	public void setTrailer(String trailer){
		this.trailer=trailer;
	}
	public String getReport(){
		return header+report+trailer;
	}
}
