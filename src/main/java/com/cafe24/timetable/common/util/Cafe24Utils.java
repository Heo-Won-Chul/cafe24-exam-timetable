package com.cafe24.timetable.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cafe24Utils {

	private static final String SPECIAL_CHARS_REGEX = "['\"\\-#()@;=*/+]";
	private static final String SQL_INJECTION_REGEX = "(UNION|SELECT|DELETE|DROP|TABLE|UPDATE|FROM|WHERE)";
	private static final String EMPTY_STRING = "";

	public static boolean isSqlInjection(String param) {
		String replacedParam = param.replaceAll(SPECIAL_CHARS_REGEX, EMPTY_STRING);
		Pattern pattern = Pattern.compile(SQL_INJECTION_REGEX);
		Matcher matcher = pattern.matcher(replacedParam.toUpperCase());
		return matcher.find();
	}
}
