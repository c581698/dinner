package com.hd.helloworld.patterns.command;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


public class DateTimeGenerator implements IGenerator {
	private static GeneratorTypeSet genType = GeneratorTypeSet.DATE_TIME;

	@Override
	public String getGeneratorType() {
		return genType.getAlias();
	}

	@Override
	public String generate(String formatStr, Map<String, Object> params) {
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern(formatStr);
		return sdf.format(new Date());
	}

}
