package com.fqyuan.math;

public class PowerOfTwoInteger {
	/**
	 * @param a
	 * @return
	 * @see log(a)/log(b) = logb(a)
	 */
	public boolean isPower(int a) {
		if (a == 1)
			return true;
		for (int i = 1; i <= Math.sqrt(a); i++) {
			for (int j = 2; j <= Math.log(a) / Math.log(2); j++) {
				if (Math.pow(i, j) == a)
					return true;
			}
		}
		return false;
	}

	public boolean isPower1(int a) {
		if (a == 1)
			return true;
		for (int i = 2; i * i <= a; i++) {
			int x = a;
			while (x % i == 0)
				x /= i;
			if (x == 1)
				return true;
		}
		return false;
	}
}
