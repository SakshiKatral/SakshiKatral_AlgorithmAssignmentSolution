package com.ssk.learning.data;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import com.ssk.learning.algorithm.BinarySearch;
import com.ssk.learning.algorithm.MergeSort;
import com.ssk.learning.app.Main;

public class DataRelatedOperation {
	int number_Of_Companies;
	double[] stock_price;
	boolean[] stockprice_status;
	Scanner scanner = new Scanner(System.in);
	MergeSort mergeSort = new MergeSort();

	public void acceptData() {
		System.out.println("Enter the number of companies");
		number_Of_Companies = scanner.nextInt();
		stock_price = new double[number_Of_Companies];
		stockprice_status = new boolean[number_Of_Companies];

		for (int i = 0; i < stock_price.length; i++) {
			System.out.println("Enter current stock price of company " + (i + 1));
			stock_price[i] = scanner.nextDouble();
			System.out.println("Whether company's stock price rose today compare to yesterday?");
			stockprice_status[i] = scanner.nextBoolean();
		}
	}

	public void operationToBePerformed() {
		int choice;
		int option = 1;

		do {
			System.out.println("\nEnter the operation that you want to perform"
					+ "\n1. Display the companies stock price in ascending order"
					+ "\n2. Display the companies stock price in descending order"
					+ "\n3. Display the total no of companies for which stock price rose today"
					+ "\n4. Display the total no of companies for which stock price declined today"
					+ "\n5. Search for a specific stock price\n6. Press 0 to exit");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				mergeSort.sort(stock_price, 0, stock_price.length - 1, choice);
				System.out.println("Stock prices in ascending order are:");
				display(stock_price);
				break;

			case 2:
				mergeSort.sort(stock_price, 0, stock_price.length - 1, choice);
				System.out.println("Stock prices in descending order are:");
				display(stock_price);
				break;
			case 3:
				System.out.println("Total no of companies whose stock price rose today: "
						+ stockStatusUpdate(stockprice_status, choice));
				break;
			case 4:
				System.out.println("Total no of companies whose stock price declined today: "
						+ stockStatusUpdate(stockprice_status, choice));
				break;
			case 5:
				searchStockValue();
				break;
			case 6:
				System.out.println("Do you want to exit if yes press 0 to exit");
				option = scanner.nextInt();
				break;
			default:
				System.out.println("Invalid option");
				break;
			}
		} while(option != 0);
		System.out.println("Exited successfully");
	}

	void display(double[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	int stockStatusUpdate(boolean[] array, int choice) {
		int rose = 0;
		int decline = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == true) {
				rose++;
			} else if (array[i] == false) {
				decline++;
			}
		}
		if (choice == 3) {
			return rose;
		} else {
			return decline;
		}
	}

	void searchStockValue() {
		System.out.println("Enter the key value");
		double searchElement = scanner.nextDouble();
		BinarySearch binarySearch = new BinarySearch();
		mergeSort.sort(stock_price, 0, stock_price.length - 1, 1);
		int index = binarySearch.binarySearch(stock_price, 0, stock_price.length - 1, searchElement);
		if (index < 0) {
			System.out.println("Stock of value " + searchElement + " is not present");
		} else {
			System.out.println("Stock of value " + searchElement + " is present");
		}
	}
}
