package com.financial.stockers;

import java.util.Scanner;

public class StockPriceService {

	private int numberOfCompanies;
	private double[] currentSharePrice;
	private boolean[] sharePriceIncrease;
	private double[] sortedSharePrice;
	HelperClass helperClass;

	public StockPriceService(int numberOfCompanies) {
		this.numberOfCompanies = numberOfCompanies;
		currentSharePrice = new double[numberOfCompanies];
		sharePriceIncrease = new boolean[numberOfCompanies];
	}

	public void getStockInformation() {
		Scanner scannerObj = new Scanner(System.in);
		for (int i = 0; i < this.numberOfCompanies; i++) {
			System.out.println("Enter details of " + (i+1) +  " Company ");
			System.out.println("Share price : ");
			currentSharePrice[i] = scannerObj.nextDouble();
			System.out.println("If shared price increased from previous day - true/false) : ");
			sharePriceIncrease[i] = scannerObj.nextBoolean();
		}
		helperClass = new HelperClass();
		sortedSharePrice = helperClass.mergeSort(currentSharePrice, 0, numberOfCompanies - 1);
	}

	public void displayStockPriceAscending() {
		for (int i = 0; i < numberOfCompanies; i++) {
			System.out.println(sortedSharePrice[i]);
		}
	}

	public void displayStockPriceDescending() {
		for (int i = numberOfCompanies - 1; i >= 0; i--) {
			System.out.println(sortedSharePrice[i]);
		}
	}

	public boolean searchPrice(double searchPrice) {
		return helperClass.searchElement(sortedSharePrice, searchPrice);
	}
	
	public int numberOfSharePriceIncreased() {
		int priceIncrease = 0;
		for (int i = 0; i < numberOfCompanies; i++) {
			if (sharePriceIncrease[i] == true) {
				priceIncrease++;
			}
		}
		return priceIncrease;
	}

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
