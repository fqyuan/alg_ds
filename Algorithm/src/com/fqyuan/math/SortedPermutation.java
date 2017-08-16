package com.fqyuan.math;

public class SortedPermutation {
	public static int findRank(String A) {
		int length = A.length();
		long strFactorial = factorial(length);
		long rank = 1;
		for (int i = 0; i < length; i++) {
			strFactorial /= length - i;
			rank += findSmallerInRight(A, i, length - 1) * strFactorial;
		}
		System.out.print("Rank : ");
		rank %= 1000003;
		return (int) rank;
	}

	public static long factorial(int n) {
		if (n == 0 || n == 1)
			return 1;
		int num = 1;
		for (int i = n; i > 1; i--)
			num = (num % 1000003 * i) % 1000003;
		return num;
	}

	public static int findSmallerInRight(String A, int low, int high) {
		int countRight = 0;
		for (int i = low + 1; i <= high; i++) {
			if (A.charAt(i) < A.charAt(low))
				countRight++;
		}
		return countRight;
	}

	public static int findEqual(String A, int low, int high) {
		int equal = 0;
		for (int i = low + 1; i <= high; i++) {
			if (A.charAt(i) == A.charAt(low))
				equal++;
		}
		return equal;
	}

	public static void main(String[] args) {
		String A = "cbb";
		System.out.println(findRank(A));
	}
}