package com.jdc.morning.utils;

import java.util.List;

public class TestUtils {

	public static<T> void show(List<T> list) {
		for(var data : list) {
			System.out.println(data);
		}
	}
}
