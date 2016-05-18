package com.hd.helloworld.patterns.interpreter;

public class TerminalExpression implements Expression {
	private String symbol;
	
	public TerminalExpression(String data) {
		symbol = data;
	}
	
	@Override
	public boolean interpret(String context) {
		return context!= null && context.contains(symbol);
	}

}
