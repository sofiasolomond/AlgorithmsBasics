package com.financial.stockers;

import java.util.Scanner;

public class StockMarketDriverClass {

	public static void main(String[] args) {
		System.out.println("Welcome to Stock Market Application !! ");
		System.out.println("Enter the number of companies whose stock price is to be entered");
		Scanner scanner = new Scanner(System.in);
		int numberOfCompanies = scanner.nextInt();
		StockPriceService stockPriceService = new StockPriceService(numberOfCompanies);
		stockPriceService.getStockInformation();
		int choice = 0;
		while (true) {
			System.out.println("------------------------------");
			System.out.println("1. Display the companies stock prices in ascending order");
			System.out.println("2. Display the companies stock prices in descending order");
			System.out.println("3. Display total number of companies for which stock prices rose today");
			System.out.println("4. Display total number of companies for which stock prices declined today");
			System.out.println("5. Search a specific stock price");
			System.out.println("0. Exit application");
			System.out.println("------------------------------");
			System.out.println("Enter you choice !");
			choice = scanner.nextInt();
			System.out.println("------------------------------");
			switch (choice) {
			case 1:
				System.out.println("Stock prices in ascending order");
				stockPriceService.displayStockPriceAscending();
				break;
			case 2:
				System.out.println("Stock prices in descending order");
				stockPriceService.displayStockPriceDescending();
				break;
			case 3:
				System.out.println("Total number of Companies whose share price rose today "
						+ stockPriceService.numberOfSharePriceIncreased());
				break;
			case 4:
				System.out.println("Total number of Companies whose share price declined today "
						+ stockPriceService.numberOfSharePriceDecreased());
				break;
			case 5:
				System.out.println("Enter the share price to be searched :");
				double searchPrice = scanner.nextDouble();
				boolean returnValue = stockPriceService.searchPrice(searchPrice);
				if (returnValue == true) {
					System.out.println("Stock of value " + searchPrice + " is present ");
				} else {
					System.out.println("Search share price " + searchPrice + " not found ");
				}
				break;
			case 0:
				System.out.println("Exited Successfully");
				scanner.close();
				System.exit(0);
				break;
			default:
				System.out.println("Give valid Input!!");
			}
		}
	}
}