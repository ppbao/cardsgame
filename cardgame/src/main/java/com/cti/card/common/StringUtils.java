package com.cti.card.common;

public class StringUtils {
	public static Long[] convertionToLong(String[] strs) {
		Long[] longs = new Long[strs.length];
		for (int i = 0; i < strs.length; i++) {
			String str = strs[i];
			long thelong = Long.valueOf(str);
			longs[i] = thelong;
		}

		return longs;
	}

}
