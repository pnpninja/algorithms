package com.github.pnpninja.algorithms;

/**
 * Class that implements all sorting algorithms
 * 
 * @author Prateek Narendra
 *
 */
public class SortAlgorithms {

	/**
	 * Sorts array by Insertion sort
	 * 
	 * @param array Array to sort
	 */
	public static void insertionSort(int[] array) {
		for(int primaryIndex = 1;primaryIndex < array.length; primaryIndex++) {
			int primaryValue = array[primaryIndex];
			int secondaryIndex = primaryIndex - 1;
			while(secondaryIndex >= 0 && array[secondaryIndex] > primaryValue) {
				array[secondaryIndex+1] = array[secondaryIndex];
				secondaryIndex -= 1;
			}
			array[secondaryIndex+1] = primaryValue;
		}
	}

	/**
	 * Sorts array by Selection sort
	 * 
	 * @param array Array to sort
	 */
	public static void selectionSort(int[] array) {
		for(int primaryIndex = 0;primaryIndex < array.length -1;primaryIndex++) {
			int minVal = array[primaryIndex];
			int minPos = primaryIndex;
			for(int secondaryIndex = primaryIndex + 1; secondaryIndex < array.length; secondaryIndex++) {
				if(array[secondaryIndex] < minVal) {
					minVal = array[secondaryIndex];
					minPos = secondaryIndex;
				}
			}
			if(minPos != primaryIndex) {
				array[primaryIndex] = array[primaryIndex] + array[minPos] - (array[minPos] = array[primaryIndex]);
			}
		}
	}

	/**
	 * Sorts array by Bubble sort
	 * 
	 * @param array Array to sort
	 */
	public static void bubbleSort(int[] array) {
		for (int primaryIndex = 0; primaryIndex < array.length; primaryIndex++) {
			for (int secondaryIndex = primaryIndex + 1; secondaryIndex < array.length; secondaryIndex++) {
				if (array[secondaryIndex] < array[primaryIndex]) {
					array[primaryIndex] = array[primaryIndex] + array[secondaryIndex]
							- (array[secondaryIndex] = array[primaryIndex]);
				}
			}

		}
	}

	/**
	 * Sort array by Merge sort
	 * 
	 * @param array
	 */
	public static void mergeSort(int[] array) {
		mergeSortInternal(array, 0, array.length - 1);
	}

	private static void mergeSortInternal(int[] array, int startPos, int endPos) {
		if (endPos == startPos + 1) {
			if (array[endPos] < array[startPos]) {
				array[startPos] = array[startPos] + array[endPos] - (array[endPos] = array[startPos]);
			}
		} else if (endPos == startPos) {

		} else {
			int midPos = (startPos + endPos) / 2;
			mergeSortInternal(array, startPos, midPos);
			mergeSortInternal(array, midPos + 1, endPos);
			int[] leftSubArray = subArray(array, startPos, midPos);
			int[] rightSubArray = subArray(array, midPos + 1, endPos);
			int[] mergedArray = merge(leftSubArray, rightSubArray);
			for (int index = 0; index < mergedArray.length; index++) {
				array[startPos + index] = mergedArray[index];
			}
		}
	}

	private static int[] subArray(int[] array, int startPos, int endPos) {
		int[] subArray = new int[endPos - startPos + 1];
		for (int index = startPos; index <= endPos; index++) {
			subArray[index - startPos] = array[index];
		}
		return subArray;
	}

	private static int[] merge(int[] leftSortedArray, int[] rightSortedArray) {
		int leftSortedArrayIndex = 0;
		int rightSortedArrayIndex = 0;
		int mergedSortedArrayIndex = 0;
		int[] mergedSortedArray = new int[leftSortedArray.length + rightSortedArray.length];
		while (true) {
			if (leftSortedArrayIndex < leftSortedArray.length && rightSortedArrayIndex < rightSortedArray.length) {
				if (leftSortedArray[leftSortedArrayIndex] < rightSortedArray[rightSortedArrayIndex]) {
					mergedSortedArray[mergedSortedArrayIndex++] = leftSortedArray[leftSortedArrayIndex++];
				} else {
					mergedSortedArray[mergedSortedArrayIndex++] = rightSortedArray[rightSortedArrayIndex++];
				}
			} else if (leftSortedArrayIndex < leftSortedArray.length) {
				mergedSortedArray[mergedSortedArrayIndex++] = leftSortedArray[leftSortedArrayIndex++];
			} else if (rightSortedArrayIndex < rightSortedArray.length) {
				mergedSortedArray[mergedSortedArrayIndex++] = rightSortedArray[rightSortedArrayIndex++];
			} else {
				break;
			}
		}
		return mergedSortedArray;
	}

	/**
	 * Sorts array using Heap Sort
	 * 
	 * @param array Array to sort
	 */
	public static void heapSort(int[] array) {
		
		//Building Max-Heap
		for (int index = (array.length / 2); index >= 0; index--) {
			heapify(array, array.length, index);
		}
		for (int index = array.length - 1; index >= 1; index--) {
			array[0] = array[0] + array[index] - (array[index] = array[0]);
			heapify(array, index, 0);
		}
	}

	private static void heapify(int[] array, int size, int rootIndex) {

		int largestIndex = rootIndex;
		int leftIndex = 2 * rootIndex + 1;
		int rightIndex = 2 * rootIndex + 2;

		if (leftIndex < size && array[leftIndex] > array[largestIndex]) {
			largestIndex = leftIndex;
		}

		if (rightIndex < size && array[rightIndex] > array[largestIndex]) {
			largestIndex = rightIndex;
		}

		if (largestIndex != rootIndex) {
			array[largestIndex] = array[largestIndex] + array[rootIndex] - (array[rootIndex] = array[largestIndex]);
			heapify(array, size, largestIndex);
		}
	}

}
