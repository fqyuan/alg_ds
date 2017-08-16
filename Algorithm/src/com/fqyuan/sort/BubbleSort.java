package com.fqyuan.sort;

import static com.fqyuan.utils.Utils.genRanArr;
import static com.fqyuan.utils.Utils.printArr;
import static com.fqyuan.utils.Utils.swap;

import org.junit.Test;

public class BubbleSort {
	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			boolean sorted = true;
			for (int j = 0; i + j < arr.length - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
					sorted = false;
				}

			}
			if (sorted)
				break;
		}
	}

	@Test
	public void test() {
		int len = 30;
		int[] arr = genRanArr(len);
		printArr(arr);
		bubbleSort(arr);
		printArr(arr);
	}
}
