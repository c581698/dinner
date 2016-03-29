package com.hd.helloworld.patterns.test.bridge;

import org.junit.Test;

import com.hd.helloworld.patterns.bridge.ASCIIReporter;
import com.hd.helloworld.patterns.bridge.HTMLReporter;
import com.hd.helloworld.patterns.bridge.Report;
import com.hd.helloworld.patterns.bridge.Reporter;

public class TestBridge {
	@Test
	public void test(){
		Reporter reporter = new HTMLReporter();
		Report report = new Report() {
		};
		
		report.addReportItem("hello world");
		System.out.println(report.report());
		
		reporter = new ASCIIReporter();
		
		report.addReportItem("long time no see");
		System.out.println(report.report());
	}
}
