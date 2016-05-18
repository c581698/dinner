package com.hd.helloworld.patterns.command;

import java.util.Map;
import java.util.Random;

public class NumberSequenceGenerator implements IGenerator {
	private static GeneratorTypeSet genType = GeneratorTypeSet.NUMBER_SEQUENCE;
	private static int init_num = new Random().nextInt(23);
	private String splitC = "C";
	
	@Override
	public String getGeneratorType() {
		return genType.getAlias();
	}

	@Override
	public String generate(String formatStr, Map<String, Object> params) {
		String[] charArray = formatStr.split(splitC);
		int seqNumLength = Integer.parseInt(charArray[0]);
		char prefixChar = charArray[1].charAt(0);
		if(seqNumLength == 0)
			return String.valueOf(init_num++);
		else
			return appendPrefixChar(init_num++,seqNumLength,prefixChar);
	}
	
	private String appendPrefixChar(int seqNum,int seqNumLength,char prefixChar)
	{
		String seqNumStr = String.valueOf(seqNum);
		for(int i = seqNumStr.length();i<seqNumLength;i++)
		{
			seqNumStr = prefixChar + seqNumStr;
		}
		return seqNumStr;
	}
}
