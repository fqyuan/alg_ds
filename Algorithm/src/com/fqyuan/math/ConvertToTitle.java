package com.fqyuan.math;

/*
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

	For example:
	
	    1 -> A
	    2 -> B
	    3 -> C
	    ...
	    26 -> Z
	    27 -> AA
	    28 -> AB 
 */
public class ConvertToTitle {
	public String convert2Title(int a) {
		StringBuilder sb = new StringBuilder();
		if (a <= 0)
			return null;
		while (a > 0) {
			a--;
			char ch = (char) (a % 26 + 'A');
			sb.append(ch);
			sb.insert(0, ch);
			a /= 26;

		}
		sb.reverse();
		return sb.toString();

	}
}
