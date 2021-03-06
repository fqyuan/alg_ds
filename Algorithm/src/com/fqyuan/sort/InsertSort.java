package com.fqyuan.sort;

import static com.fqyuan.utils.Utils.genRanArr;
import static com.fqyuan.utils.Utils.printArr;

import org.junit.Test;

public class InsertSort {
	public static void insertSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
			for (; j >= 0 && arr[j] > key; j--) {
				arr[j + 1] = arr[j];
			}
			arr[j + 1] = key;
		}
	}

	@Test
	public void test() {
		int len = 30;
		int[] arr = genRanArr(len);
		printArr(arr);
		insertSort(arr);
		printArr(arr);
	}
}
