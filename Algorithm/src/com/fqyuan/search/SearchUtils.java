package com.fqyuan.search;

public class SearchUtils {
	public static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%-3d%s", arr[i], " ");
			if ((i + 1) % 20 == 0)
				System.out.println();
		}

	}
}
