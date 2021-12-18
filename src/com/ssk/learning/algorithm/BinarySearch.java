package com.ssk.learning.algorithm;

public class BinarySearch {
	public int binarySearch(double[] stockPrice, int left, int right, double search) {
		if (left > right) {
			return -1;
		}

		int mid = (left + right) / 2;
		if (search == stockPrice[mid]) {
			return mid;
		} else if (search > stockPrice[mid]) {
			return binarySearch(stockPrice, (mid + 1), right, search);
		} else {
			return binarySearch(stockPrice, left, (mid - 1), search);
		}
	}

}
