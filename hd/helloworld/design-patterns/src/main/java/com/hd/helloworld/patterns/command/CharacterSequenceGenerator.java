package com.hd.helloworld.patterns.command;

import java.util.Map;

public class CharacterSequenceGenerator implements IGenerator {

	private static GeneratorTypeSet genType = GeneratorTypeSet.CHARATER_SEQUENCE;
	private char c = 'A'; 
	
	@Override
	public String getGeneratorType() {
		return genType.getAlias();
	}

	@Override
	public String generate(String formatStr, Map<String, Object> params) {
		return String.valueOf((char)c++);
	}

}
