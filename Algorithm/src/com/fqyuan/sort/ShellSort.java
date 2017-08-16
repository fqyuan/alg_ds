package com.fqyuan.sort;

import static com.fqyuan.utils.Utils.genRanArr;
import static com.fqyuan.utils.Utils.printArr;

import org.junit.Test;

public class ShellSort {
	public static void shellSort(int[] arr) {
		for (int gap = arr.length / 2; gap > 0; gap = (gap == 2) ? 1 : (int) (gap / 2.2)) {
			for (int i = gap; i < arr.length; i++) {
				int j = i - gap;
				int key = arr[i];
				for (; j >= 0 && arr[j] > key; j -= gap) {
					arr[j + gap] = arr[j];
				}
				arr[j + gap] = key;
			}
		}
	}

	@Test
	public void test() {
		int len = 30;
		int[] arr = genRanArr(len);
		printArr(arr);
		shellSort(arr);
		printArr(arr);
	}
}
