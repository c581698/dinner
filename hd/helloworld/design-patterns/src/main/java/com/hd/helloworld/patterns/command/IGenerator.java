package com.hd.helloworld.patterns.command;

import java.util.Map;

public interface IGenerator {
	public String getGeneratorType();
	public String generate(String formatStr,Map<String,Object> params);
}
