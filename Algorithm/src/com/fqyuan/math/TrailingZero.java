package com.fqyuan.math;

public class TrailingZero {
	public int trailingZeroes(int a) {
		return a == 0 ? 0 : a / 5 + trailingZeroes(a / 5);
	}
}
