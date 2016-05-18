package com.hd.helloworld.patterns.chain;

public class InfoLog implements ILog {
	private ILog next;
	
	public InfoLog() {
	}
	public InfoLog(ILog next) {
		setNext(next);
	}
	
	@Override
	public void print(ILog log,String msg) {
		if(log instanceof InfoLog){
			System.out.println("LOG MSG:"+msg);
		}else if(null != next)
			next.print(next, msg);
	}

	@Override
	public void setNext(ILog log) {
		this.next = log;
	}
}
