package com.fqyuan.String;

import java.lang.reflect.Field;

public class StrMut {

	public static void main(String[] args) throws Exception {
		String str1 = "stack";
		String str2 = "stack";
		String str3 = str1.substring(2);
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);

		Field field = String.class.getDeclaredField("value");
		field.setAccessible(true);
		char[] value = (char[]) field.get(str1);
		value[2] = 'u';
		value[3] = 'd';
		value[4] = 'y';
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
	}

}
