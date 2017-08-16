package com.fqyuan.math;

import java.util.ArrayList;

public class FizzBuzz {
	/*
	 * Given a positive integer N, print all the integers from 1 to N. But for
	 * multiples of 3 print ��Fizz�� instead of the number and for the multiples
	 * of 5 print ��Buzz��. Also for number which are multiple of 3 and 5, prints
	 * ��FizzBuzz��.
	 * 
	 * Example
	 * 
	 * N = 5 Return: [1 2 Fizz 4 Buzz] Note: Instead of printing the answer, you
	 * have to return it as list of strings.
	 */
	public ArrayList<String> fizzBuzz(int A) {
		ArrayList<String> result = new ArrayList<>();
		for (int i = 1; i < A; i++) {
			if (i % 3 == 0 && i % 5 == 0)
				result.add("FizzBuzz");
			else if (i % 3 == 0)
				result.add("Fizz");
			else if (i % 5 == 0)
				result.add("Buzz");
			else
				result.add(String.valueOf(i));
		}
		return result;
	}
}
