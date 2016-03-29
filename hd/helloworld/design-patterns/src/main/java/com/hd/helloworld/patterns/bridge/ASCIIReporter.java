package com.hd.helloworld.patterns.bridge;

public class ASCIIReporter extends Reporter {

	@Override
	public void addLine(String line) {
		report += line+"\n";
	}
}
