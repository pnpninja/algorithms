package com.github.pnpninja.algorithms.arrays;

public class SortAlgorithms {
	
	public static void insertionSort(int[] array) {
		for(int primaryIndex = 0;primaryIndex < array.length;primaryIndex++) {
			for(int secondaryIndex = primaryIndex+1;secondaryIndex < array.length;secondaryIndex++) {
				if(array[secondaryIndex]<array[primaryIndex]) {
					int smallerElement = array[secondaryIndex];
					for(int i = secondaryIndex-1;i>=primaryIndex;i--) {
						array[i+1] = array[i];
					}
					array[primaryIndex] = smallerElement;
				}
			}
		}
	}
	
	public static void selectionSort(int[] array) {
		for(int primaryIndex = 0;primaryIndex < array.length;primaryIndex++) {
			int minVal = array[primaryIndex];
			int minPos = primaryIndex;
			for(int secondaryIndex = primaryIndex+1;secondaryIndex < array.length;secondaryIndex++) {
				if(array[secondaryIndex]<minVal) {
					minVal = array[secondaryIndex];
					minPos = secondaryIndex;
				}
			}
			if(primaryIndex!=minPos) {
				array[primaryIndex] = array[primaryIndex] + array[minPos] - (array[minPos] = array[primaryIndex]);
			}
		}
	}
	

}
