package com.fqyuan.sort;

import static com.fqyuan.utils.Utils.genRanArr;
import static com.fqyuan.utils.Utils.printArr;
import static com.fqyuan.utils.Utils.swap;

import org.junit.Test;

public class QuickSort {
	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	private static void quickSort(int[] arr, int low, int high) {
		if (low > high)
			return;
		// int pivot = incPartition(arr, low, high);
		int pivot = decPartition(arr, low, high);
		quickSort(arr, low, pivot - 1);
		quickSort(arr, pivot + 1, high);
	}

	private static int incPartition(int[] arr, int low, int high) {
		int pivotIndex = low;
		int pivotValue = arr[high];
		for (int i = low; i < high; i++) {
			if (arr[i] <= pivotValue)
				swap(arr, i, pivotIndex++);
		}
		swap(arr, pivotIndex, high);
		return pivotIndex;
	}

	private static int decPartition(int[] arr, int low, int high) {
		int pivotIndex = low;
		int pivotValue = arr[low];
		for (int i = low + 1; i <= high; i++) {
			if (arr[i] >= pivotValue)
				swap(arr, i, ++pivotIndex);
		}
		swap(arr, pivotIndex, low);
		return pivotIndex;
	}

	@Test
	public void test() {
		int len = 30;
		int[] arr = genRanArr(len);
		printArr(arr);
		quickSort(arr);
		printArr(arr);
	}
}
