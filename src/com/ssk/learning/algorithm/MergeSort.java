package com.ssk.learning.algorithm;

public class MergeSort {
	public void sort(double[] stockprice, int left, int right, int choice) {

		if (left < right) {

			int mid = (left + right) / 2;

			// first half
			sort(stockprice, left, mid, choice);

			// right half
			sort(stockprice, mid + 1, right, choice);

			merge(stockprice, left, right, mid, choice);
		}
	}

	public void merge(double[] stockPrice, int left, int right, int mid, int choice) {
		int leftArraySize = mid - left + 1;
		int rightArraySize = right - mid;

		// create temporary arrays based on size
		double[] leftArray = new double[leftArraySize];
		double[] rightArray = new double[rightArraySize];

		for (int i = 0; i < leftArraySize; i++) {
			leftArray[i] = stockPrice[left + i];
		}

		for (int j = 0; j < rightArraySize; j++) {
			rightArray[j] = stockPrice[mid + 1 + j];
		}

		// merge temporary array
		int i = 0, j = 0;
		int k = left;

		while (i < leftArraySize && j < rightArraySize) {
			if (choice == 1) {
				if (leftArray[i] <= rightArray[j]) {
					stockPrice[k] = leftArray[i];
					i++;
				} else {
					stockPrice[k] = rightArray[j];
					j++;
				}
				k++;
			} 
			else {
				if (rightArray[j] <= leftArray[i]) {
					stockPrice[k] = leftArray[i];
					i++;
				} else {
					stockPrice[k] = rightArray[j];
					j++;
				}
				k++;
			}
		}
		while (i < leftArraySize) {
			stockPrice[k] = leftArray[i];
			i++;
			k++;
		}
		while (j < rightArraySize) {
			stockPrice[k] = rightArray[j];
			j++;
			k++;
		}
	}
}


