package com.fqyuan.sort;

import static com.fqyuan.utils.Utils.genRanArr;
import static com.fqyuan.utils.Utils.printArr;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class RadixSort {
	public void radixSort(int[] arr) {
		// 1. Initialize the original buckets.
		Queue<Integer>[] buckets = new LinkedList[10];
		for (int i = 0; i < 10; i++)
			buckets[i] = new LinkedList<>();
		int exp = 1;
		boolean sorted = false;
		while (!sorted) {
			sorted = true;
			// 2. Scatter the elements into the buckets.
			for (int val : arr) {
				int bucket = val / exp % 10;
				buckets[bucket].add(val);
				if (bucket > 0)
					sorted = false;
			}
			// 3. Gather the elements into the original array.
			exp *= 10;
			int index = 0;
			for (int i = 0; i < 10; i++) {
				while (!buckets[i].isEmpty())
					arr[index++] = buckets[i].remove();
			}
		}

	}

	@Test
	public void test() {
		int len = 20;
		int[] arr = genRanArr(len);
		printArr(arr);
		radixSort(arr);
		printArr(arr);
	}
}
