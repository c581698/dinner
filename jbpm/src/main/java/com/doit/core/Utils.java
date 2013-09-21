package com.doit.core;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Utils {
	public static void main(String[] args) throws IOException {
		get();
		
	}
	
	public static void get() throws IOException {
		File file = new File("C:\\Users\\Administrator\\.m2");
		
		file.mkdir();
	}
}
