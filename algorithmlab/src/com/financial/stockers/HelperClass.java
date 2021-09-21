package com.financial.stockers;

public class HelperClass {

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
