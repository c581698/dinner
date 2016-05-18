package com.hd.helloworld.patterns.command;

import java.util.HashMap;
import java.util.Map;

public final class SNGeneratorEngine {
	private static SNGeneratorEngine snGeneratorEngine = new SNGeneratorEngine();
	private static Map<String, IGenerator> generatorMap = new HashMap<String, IGenerator>();
	/** 流水号生成规则 */
	private String formatStr;
	/** 子序列间分隔符 */
	private String splitChar = "#";
	/** 子序列内部分隔符 */
	private String innerChar = "@";
	/** 流水号子序列生成规则 */
	private String[] subFormatStr;

	public void addGenerator(IGenerator Generator) {
		generatorMap.put(Generator.getGeneratorType(), Generator);
	}

	public static SNGeneratorEngine getInstance() {
		return snGeneratorEngine;
	}

	public void setFormatStr(String formatStr) {
		this.formatStr = formatStr;
		subFormatStr = this.formatStr.split(splitChar);
	}

	public String generate(Map parameterMap) {
		StringBuffer seriableNumber = new StringBuffer();
		for (String format : subFormatStr) {
			seriableNumber.append(generateSubSN(format, parameterMap));
		}
		return seriableNumber.toString();
	}

	private String generateSubSN(String subFormatStr, Map<String,Object> parameterMap) {
		String[] innerSubStr = subFormatStr.split(innerChar);
		IGenerator Generator = this.getGenerator(innerSubStr[0]);
		return Generator.generate(innerSubStr[1], parameterMap);
	}

	private IGenerator getGenerator(String generatorType) {
		return generatorMap.get(generatorType);
	}

	private SNGeneratorEngine() {
	}

}
