package com.fqyuan.math;

public class GCD {
	public int gcd(int a, int b) {
		int res = -1;
		if (a == 1 || b == 1)
			return 1;
		if (a == 0)
			return b;
		if (b == 0)
			return a;
		for (int i = 1; i <= a && i <= b; i++) {
			if (a % i == 0 && b % i == 0)
				res = i;
		}
		return res;
	}

	public int gcd1(int a, int b) {
		if (a == 0)
			return b;
		return gcd1(b % a, a);
	}
}
