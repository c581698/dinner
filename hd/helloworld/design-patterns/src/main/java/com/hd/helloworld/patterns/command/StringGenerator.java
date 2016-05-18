package com.hd.helloworld.patterns.command;

import java.util.Map;

public class StringGenerator implements IGenerator {

	private static GeneratorTypeSet genType = GeneratorTypeSet.STRING;

	@Override
	public String getGeneratorType() {
		return genType.getAlias();
	}


	@Override
	public String generate(String formatStr, Map<String, Object> params) {
		return formatStr;
	}

}
