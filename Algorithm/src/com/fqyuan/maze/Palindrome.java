package com.fqyuan.maze;

public class Palindrome {
	public boolean isPalindrome(int a) {
		return reverseNum(a) == a;
	}

	private int reverseNum(int a) {
		int reversd = 0;
		if (a == 0)
			return 0;
		while (a > 0) {
			reversd = reversd * 10 + a % 10;
			a /= 10;
		}
		return reversd;
	}
}
