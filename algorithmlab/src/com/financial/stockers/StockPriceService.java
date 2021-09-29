package com.financial.stockers;

import java.util.Scanner;

public class StockPriceService {

	private int numberOfCompanies;
	private double[] currentSharePrice;
	private boolean[] sharePriceIncrease;
	private double[] sortedSharePrice;
	HelperClass helperClass;

	// Constructor of the class
	public StockPriceService(int numberOfCompanies) {
		this.numberOfCompanies = numberOfCompanies;
		currentSharePrice = new double[numberOfCompanies];
		sharePriceIncrease = new boolean[numberOfCompanies];
	}

	// Get input values for the operation and sort the array of share price
	public void getStockInformation() {
		Scanner scannerObj = new Scanner(System.in);
		for (int i = 0; i < this.numberOfCompanies; i++) {
			System.out.println("Enter details of " + (i + 1) + " Company ");
			System.out.println("Share price : ");
			currentSharePrice[i] = scannerObj.nextDouble();
			System.out.println("If shared price increased from previous day - true/false) : ");
			sharePriceIncrease[i] = scannerObj.nextBoolean();
		}
		helperClass = new HelperClass();
		sortedSharePrice = helperClass.mergeSort(currentSharePrice, 0, numberOfCompanies - 1);
	}

	// Display the stock is ascending order
	public void displayStockPriceAscending() {
		for (int i = 0; i < numberOfCompanies; i++) {
			System.out.println(sortedSharePrice[i]);
		}
	}

	// Display the stock in descending oder
	public void displayStockPriceDescending() {
		for (int i = numberOfCompanies - 1; i >= 0; i--) {
			System.out.println(sortedSharePrice[i]);
		}
	}

	// Search for the share price in the sorted array
	public boolean searchPrice(double searchPrice) {
		return helperClass.searchElement(sortedSharePrice, searchPrice);
	}

	// find the number of companies whose share price increased
	public int numberOfSharePriceIncreased() {
		int priceIncrease = 0;
		for (int i = 0; i < numberOfCompanies; i++) {
			if (sharePriceIncrease[i] == true) {
				priceIncrease++;
			}
		}
		return priceIncrease;
	}

	// find the number of companies whose share price decreased
	public int numberOfSharePriceDecreased() {
		int priceDecrease = 0;
		for (int i = 0; i < numberOfCompanies; i++) {
			if (sharePriceIncrease[i] == false) {
				priceDecrease++;
			}
		}
		return priceDecrease;
	}
}
