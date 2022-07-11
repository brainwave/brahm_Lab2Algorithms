package com.problem2.solution;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String argv[]) {

		Scanner sc = new Scanner(System.in);

		try {
			System.out.printf("Enter size of currency denominations: ");
			int numDenominations = sc.nextInt();
			if (numDenominations < 1) {
				throw new ArithmeticException("number of denominations should be a natural number");
			}
			DenominationFinder df = new DenominationFinder(numDenominations);

			System.out.println("Enter the denomination value: ");
			for (int i = 0; i < numDenominations; i++)
				df.recordDenomination(sc.nextInt());

			System.out.printf("Enter the amount you want to pay: ");
			int payAmount = sc.nextInt();
			if (payAmount < 1) {
				throw new ArithmeticException("Amount to pay should be a natural number!");
			}

			df.countCurrency(payAmount);
			df.showCurrency();

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
