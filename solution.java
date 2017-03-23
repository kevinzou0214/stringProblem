package com.apple.itunes;

public class solution {
	public static String removeChar(final String str, final char cha) {
		if (str == null)
			return null;
		final StringBuilder builder = new StringBuilder();
		for (char character : str.toCharArray()) {
			if (character != cha) {
				builder.append(character);
			}	
		}
		return builder.toString();
	}
	public static String removeCharOneLine(final String str, final char cha) {
		if (str == null)
			return null;
		return str.replaceAll(String.valueOf(cha), "");
	
	}
}
