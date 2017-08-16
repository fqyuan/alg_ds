package com.fqyuan.math;

import java.util.ArrayList;

public class InsideRec {
	public int cntInsideRec(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C, ArrayList<Integer> D) {
		int cnt = 0;
		for (int i = 0; i < C.size(); i++) {
			if (isInRec(C.get(i), D.get(i), A, B))
				cnt++;
		}
		return cnt;
	}

	private double recArea(int x1, int y1, int x2, int y2, int x3, int y3) {
		double area = ((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)));

		if (area < 0)
			area *= -1;
		return area;
	}

	private boolean isInRec(int x, int y, ArrayList<Integer> A, ArrayList<Integer> B) {
		int x1 = A.get(0), x2 = A.get(1), x3 = A.get(2), x4 = A.get(3);
		int y1 = B.get(0), y2 = B.get(1), y3 = B.get(2), y4 = B.get(3);

		double oriArea = recArea(x1, y1, x2, y2, x3, y3);
		double area1, area2, area3, area4;
		area1 = recArea(x, y, x1, y1, x2, y2) / 2;
		area2 = recArea(x, y, x1, y1, x4, y4) / 2;
		area3 = recArea(x, y, x2, y2, x3, y3) / 2;
		area4 = recArea(x, y, x3, y3, x4, y4) / 2;
		if (area1 == 0 || area2 == 0 || area3 == 0 || area4 == 0)
			return false;
		return (area1 + area2 + area3 + area4) == oriArea;

	}
}
