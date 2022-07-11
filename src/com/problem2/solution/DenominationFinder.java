package com.problem2.solution;

import java.util.Arrays;
import java.util.Collections;

public class DenominationFinder {
	// function to count and
	// print currency notes
	private Integer[] validDenominations;
	private int counter;
	private Integer[] currencyCount;

	DenominationFinder(int currencySize) {
		this.counter = 0;

		// initialize array sizes
		this.validDenominations = new Integer[currencySize];
		this.currencyCount = new Integer[currencySize];
	}

	public void recordDenomination(int denomination) {
		this.validDenominations[counter++] = denomination;
	}

	public void countCurrency(int payAmount) {
		// do a greedy search for notes (should be optimal based on internet research
		Arrays.sort(this.validDenominations, Collections.reverseOrder()); // sort array in descending order

		for (int i = 0; i < this.counter; i++) {
			if (payAmount >= this.validDenominations[i]) {
				this.currencyCount[i] = (payAmount / this.validDenominations[i].intValue());
				payAmount = payAmount % this.validDenominations[i];
			}
		}
	}

	public void showCurrency() {
		// Print notes
		System.out.println("Currency Count ->");
		for (int i = 0; i < this.counter; i++) {
			if (this.currencyCount[i] != null) {
				System.out.println(this.validDenominations[i] + " : " + this.currencyCount[i]);
			}
		}
	}
}
