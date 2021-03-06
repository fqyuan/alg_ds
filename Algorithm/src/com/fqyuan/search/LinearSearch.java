package com.fqyuan.search;

import java.util.Random;

import org.junit.Test;

public class LinearSearch {
	public static int linearch(int[] arr, int target) {
		int index = -1;
		for (int i = 0; i < arr.length; i++) {
			if (target == arr[i]) {
				index = i;
				break;
			}
		}
		return index;
	}

	@Test
	public void test() {
		int[] arr = new int[100];
		Random random = new Random();
		for (int i = 0; i < arr.length; i++)
			arr[i] = random.nextInt(arr.length);
		SearchUtils.printArr(arr);
		if (linearch(arr, 50) != -1)
			System.out.println("Found 50 at: " + linearch(arr, 50));
		else
			System.out.println("Not found.");
	}
}
