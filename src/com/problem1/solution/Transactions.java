package com.problem1.solution;

public class Transactions {

	private int[] transactsArray; // using integer as transactions can be positive or negative
	private long[] cummulativeSum; // using long to prevent integer overflow

	private int transactionCount;

	// Constructor to arrange memory for nested object
	public Transactions(int arraySize) {

		if (arraySize <= 0) { // handle wrong array size specification
			System.out.println("Entered array size should be greater than 0, please retry");
			return;
		}

		this.transactsArray = new int[arraySize + 1]; // allocate all needed memory in 1 shot
		this.cummulativeSum = new long[arraySize + 1]; // takes up space but allows us to add without worry

		this.cummulativeSum[0] = 0; // initialize sum to 0
		this.transactsArray[0] = 0;
	}

	public void recordTransaction(int transactValue) {
		this.transactsArray[++transactionCount] = transactValue;
		this.cummulativeSum[transactionCount] = transactValue + this.cummulativeSum[transactionCount - 1];
	}

	public void checkTarget(int transactTarget) {
		for (int i = 1; i <= this.transactionCount; i++)
			if (this.cummulativeSum[i] >= transactTarget) {
				System.out.println("Target achieved after " + i + " transactions");
				return;
			}
		System.out.println("Given target not achieved");
	}

}
