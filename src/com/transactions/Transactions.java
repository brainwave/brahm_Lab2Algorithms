package com.transactions;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.ListIterator;

public class Transactions {

	//Using arraylists since transactions might grow to be beyond the input size
	
	ArrayList<Integer>  transactsArray;  //using integer as transactions can be positive or negative
	ArrayList<BigInteger> cummulativeSum; //using biginteger to prevent integer overflow
	ListIterator<Integer> transactsIterator;
	ListIterator<Integer> sumIterator;
	
	//Constructor to arrange memory for nested object
	Transactions(Integer arraySize) {
		this.transactsArray = new ArrayList<Integer>(arraySize); //iterator for transactions
		this.transactsIterator= transactsArray.listIterator(); //iterator for sum
		this.sumIterator = transactsArray.listIterator();
	}
	
	public void addTransaction(Integer transactValue) {
		this.transactsArray.add(transactValue);
		this.cummulativeSum
	}
}
