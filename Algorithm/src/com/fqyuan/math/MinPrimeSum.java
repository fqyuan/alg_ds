package com.fqyuan.math;

import java.util.ArrayList;

public class MinPrimeSum {
	/**
	 * @param a
	 * @return
	 * @see Given an even number ( greater than 2 ), return two prime numbers
	 *      whose sum will be equal to given number.
	 * 
	 *      NOTE A solution will always exist. read Goldbach��s conjecture
	 * 
	 *      Example:
	 * 
	 * 
	 *      Input : 4 Output: 2 + 2 = 4
	 * 
	 *      If there are more than one solutions possible, return the
	 *      lexicographically smaller solution.
	 * 
	 *      If [a, b] is one solution with a <= b, and [c,d] is another solution
	 *      with c <= d, then
	 * 
	 *      [a, b] < [c, d]
	 * 
	 *      If a < c OR a==c AND b < d.
	 */
	public ArrayList<Integer> primeSum(int a) {
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 2; i < a; i++) {
			if (isPrime(i) && isPrime(a - i)) {
				result.add(i);
				result.add(a - i);
				break;
			}
		}
		return result;
	}

	private boolean isPrime(int num) {
		for (int i = 2; i <= (int) Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
}
