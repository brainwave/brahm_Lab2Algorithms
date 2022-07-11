package com.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.transactions.Transactions;

public class Main {
	public static void main(String argv[]) {

		Scanner sc = new Scanner(System.in);

		try {
			System.out.printf("Enter size of transaction array: ");
			int numTransactions = sc.nextInt();
			if (numTransactions < 1) {
				throw new ArithmeticException("number of transactions should be a natural number");
			}
			Transactions transactions = new Transactions(numTransactions);

			System.out.println("Enter values in the array");
			for (int i = 0; i < numTransactions; i++)
				transactions.recordTransaction(sc.nextInt());

			System.out.printf("Enter the number of targets to be checked: \n");
			int numTargets = sc.nextInt();
			if (numTargets < 1) {
				throw new ArithmeticException("number of targets should be a natural number");
			}

			for (int i = 0; i < numTargets; i++) {
				System.out.println("Enter value of the target");
				transactions.checkTarget(sc.nextInt());
			}

			System.out.println("Exiting");

		} catch (ArithmeticException e) {
			System.out.println(e.getMessage() + ". Please try again");
		} catch (InputMismatchException e) {
			System.out.println("Non integer input received. Please retry by giving integer inputs. Exiting.");
		} finally {
			sc.close(); // resource leak if sc not closed
		}
	}
}
