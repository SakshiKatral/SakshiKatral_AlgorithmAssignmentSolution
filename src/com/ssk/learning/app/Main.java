package com.ssk.learning.app;

import java.util.Scanner;

import com.ssk.learning.data.DataRelatedOperation;

public class Main {

	public static void main(String[] args) {
		DataRelatedOperation dataRelatedOperation = new DataRelatedOperation();
		dataRelatedOperation.acceptData();
		dataRelatedOperation.operationToBePerformed();
	}
}
