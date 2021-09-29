package com.financial.stockers;

public class HelperClass {

	/*
	 * mergeSort() sorts the given array using merge sort  
	 * Param 1 : double sharePriceList [] - an array of unsorted elements for sorting 
	 * Param 2 : int left - starting element of the array 
	 * Param 3 : int right - last element of the array
	 * return value : returns sorted array
	 */

	public double[] mergeSort(double sharePriceList[], int left, int right) {
		int mid = (left + right) / 2;
		if (left < right) {
			mergeSort(sharePriceList, left, mid);
			mergeSort(sharePriceList, mid + 1, right);
			mergeJoin(sharePriceList, left, mid, right);
		}
		return sharePriceList;
	}

	public void mergeJoin(double[] sharePriceList, int left, int mid, int right) {
		int sizeOfFirstArray = mid - left + 1;
		int sizeOfSecondArray = right - mid;
		double[] tempFirstArray = new double[sizeOfFirstArray];
		double[] tempSecondArray = new double[sizeOfSecondArray];
		for (int i = 0; i < sizeOfFirstArray; i++) {
			tempFirstArray[i] = sharePriceList[left + i];
		}
		for (int j = 0; j < sizeOfSecondArray; j++) {
			tempSecondArray[j] = sharePriceList[mid + 1 + j];
		}
		int indexOfOriginalArray = left;
		int indexOfFirstSubAray = 0;
		int indexOfSecondSubAray = 0;

		while (indexOfFirstSubAray < sizeOfFirstArray && indexOfSecondSubAray < sizeOfSecondArray) {
			if (tempFirstArray[indexOfFirstSubAray] < tempSecondArray[indexOfSecondSubAray]) {
				sharePriceList[indexOfOriginalArray] = tempFirstArray[indexOfFirstSubAray];
				indexOfFirstSubAray++;
				indexOfOriginalArray++;
			} else {
				sharePriceList[indexOfOriginalArray] = tempSecondArray[indexOfSecondSubAray];
				indexOfSecondSubAray++;
				indexOfOriginalArray++;
			}
		}
		while (indexOfFirstSubAray < sizeOfFirstArray) {
			sharePriceList[indexOfOriginalArray] = tempFirstArray[indexOfFirstSubAray];
			indexOfFirstSubAray++;
			indexOfOriginalArray++;
		}
		while (indexOfSecondSubAray < sizeOfSecondArray) {
			sharePriceList[indexOfOriginalArray] = tempSecondArray[indexOfSecondSubAray];
			indexOfSecondSubAray++;
			indexOfOriginalArray++;
		}
	}

	/*
	 * searchElement() uses binary search to search for a given value 
	 * Input param 1 - double [] sortedSharePriceList - an array of sorted elements 
	 * Input param 2 - double searchElement - the element to be  searched 
	 * Return - true if search element is found else returns false
	 */
	public boolean searchElement(double[] sortedSharePriceList, double searchELement) {
		int start = 0;
		int end = sortedSharePriceList.length - 1;
		int mid = (start + end) / 2;
		while (start <= end) {
			if (searchELement == sortedSharePriceList[mid]) {
				return true;
			}
			if (searchELement > sortedSharePriceList[mid]) {
				start = mid + 1;
				end = sortedSharePriceList.length - 1;
				mid = (start + end) / 2;
			}
			if (searchELement < sortedSharePriceList[mid]) {
				start = 0;
				end = mid - 1;
				mid = (start + end) / 2;
			}
		}
		return false;
	}
}
