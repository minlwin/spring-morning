package com.jdc.test.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private static DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
	
	public static Date parse(String str) {
		try {
			return null == str ? null : fmt.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
