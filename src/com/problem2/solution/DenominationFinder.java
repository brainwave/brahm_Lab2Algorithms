package com.problem2.solution;

public class DenominationFinder {
	// function to count and
	// print currency notes
	private int[] validDenominations;
	private int counter;
	private int[] currencyCount;

	DenominationFinder(int currencySize) {
		this.counter = 0;

		// initialize array sizes
		validDenominations = new int[currencySize];
		currencyCount = new int[currencySize];
	}

	public void recordDenomination(int denomination) {
		this.validDenominations[counter++] = denomination;
	}

	public void countCurrency(int payAmount) {
		// do a greedy search for notes (should be optimal based on internet research
		for (int i = 0; i < this.counter; i++) {
			if (payAmount >= this.validDenominations[i]) {
				this.currencyCount[i] = payAmount / this.validDenominations[i];
				payAmount = payAmount % this.validDenominations[i];
			}
		}
	}

	public void showCurrency() {
		// Print notes
		System.out.println("Currency Count ->");
		for (int i = 0; i < this.counter; i++) {
			if (this.currencyCount[i] != 0) {
				System.out.println(this.validDenominations[i] + " : " + this.currencyCount[i]);
			}
		}
	}
}
