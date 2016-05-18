package com.hd.helloworld.patterns.chain;

public class ErrorLog implements ILog {

	private ILog next;
	public ErrorLog() {
	}
	public ErrorLog(ILog next) {
		setNext(next);
	}
	@Override
	public void print(ILog log, String msg) {
		if(log instanceof ErrorLog){
			System.out.println("ERROR MSG:"+msg);
		}else if(null != next)
			next.print(next, msg);
	}

	@Override
	public void setNext(ILog log) {
		this.next = log;
	}

}
