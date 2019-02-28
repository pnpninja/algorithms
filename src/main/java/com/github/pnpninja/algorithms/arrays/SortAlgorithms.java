package com.github.pnpninja.algorithms.arrays;
/**
 * Class that implements all sorting algorithms
 * @author Prateek Narendra
 *
 */
public class SortAlgorithms {
	
	/**
	 * Sorts array by Insertion sort
	 * @param array Array to sort
	 */
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
	
	/**
	 * Sorts array by Selection sort
	 * @param array Array to sort
	 */
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
	
	/**
	 * Sorts array by Bubble sort
	 * @param array Array to sort
	 */
	public static void bubbleSort(int[] array) {
		for(int primaryIndex = 0;primaryIndex < array.length;primaryIndex++) {
			for(int secondaryIndex = primaryIndex+1;secondaryIndex < array.length;secondaryIndex++) {
				if(array[secondaryIndex]<array[primaryIndex]) {
					array[primaryIndex] = array[primaryIndex] + array[secondaryIndex] - (array[secondaryIndex] = array[primaryIndex]);
				}
			}
			
		}
	}
	
	/**
	 * Sort array by Merge sort
	 * @param array
	 */
	public static void mergeSort(int[] array) {
		mergeSortInternal(array, 0, array.length-1);
	}
	
	private static void mergeSortInternal(int[] array,int startPos,int endPos) {
		if(endPos==startPos+1) {
			if(array[endPos]<array[startPos]) {
				array[startPos] = array[startPos] + array[endPos] - (array[endPos] = array[startPos]);
			}	
		}else if(endPos == startPos){
			
		}else {
			int midPos = (startPos + endPos)/2;
			mergeSortInternal(array,startPos,midPos);
			mergeSortInternal(array,midPos+1,endPos);
			int[] leftSubArray = subArray(array,startPos,midPos);
			int[] rightSubArray = subArray(array,midPos+1,endPos);
			int[] mergedArray = merge(leftSubArray,rightSubArray);
			for(int index = 0;index<mergedArray.length;index++) {
				array[startPos+index] = mergedArray[index];
			}		
		}
	}
	
	private static int[] subArray(int[] array, int startPos, int endPos) {
		int[] subArray = new int[endPos - startPos+1];
		for(int index = startPos;index<=endPos;index++) {
			subArray[index-startPos] = array[index];
		}
		return subArray;
	}
	
	
	private static int[] merge(int[] leftSortedArray, int[] rightSortedArray) {
		int leftSortedArrayIndex = 0;
		int rightSortedArrayIndex = 0;
		int mergedSortedArrayIndex = 0;
		int[] mergedSortedArray = new int[leftSortedArray.length + rightSortedArray.length];
		while(true) {
			if(leftSortedArrayIndex<leftSortedArray.length && rightSortedArrayIndex<rightSortedArray.length) {
				if(leftSortedArray[leftSortedArrayIndex]<rightSortedArray[rightSortedArrayIndex]) {
					mergedSortedArray[mergedSortedArrayIndex++] = leftSortedArray[leftSortedArrayIndex++];
				}else {
					mergedSortedArray[mergedSortedArrayIndex++] = rightSortedArray[rightSortedArrayIndex++];
				}
			}else if(leftSortedArrayIndex<leftSortedArray.length) {
				mergedSortedArray[mergedSortedArrayIndex++] = leftSortedArray[leftSortedArrayIndex++];
			}else if(rightSortedArrayIndex<rightSortedArray.length){
				mergedSortedArray[mergedSortedArrayIndex++] = rightSortedArray[rightSortedArrayIndex++];
			}else {
				break;
			}
		}
		return mergedSortedArray;		
	}
	
	
}
