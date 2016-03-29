package com.hd.helloworld.patterns.bridge;

public class HTMLReporter extends Reporter {
	
	public HTMLReporter() {
		setHeader("<HTML>\n<HEAD></HEAD>\n<BODY>\n");
		setTrailer("</BODY>\n</HTML>");
	}

	@Override
	public void addLine(String line) {
		report += line+"<br/>\n";
	}
}
