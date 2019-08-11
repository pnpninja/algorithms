package com.github.pnpninja.algorithms;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Random;
import org.junit.Test;

import com.github.pnpninja.algorithms.SortAlgorithms;

public class SortAlgorithmsTest {
	
	int[] array = new int[10000];
	
	public void initArray() {
		Random random = new Random();
		for (int i = 0; i < 10000; i++)
		{
			array[i] = random.nextInt(1000);
		}

	}
	
	@Test
	public void testInsertionSort() {
		initArray();
		int[] sortedByDefault = Arrays.copyOfRange(array, 0, array.length);
		Arrays.sort(sortedByDefault);
		SortAlgorithms.insertionSort(array);		
		assertTrue(Arrays.equals(array, sortedByDefault));
		
	}
	
	
	@Test
	public void testSelectionSort() {
		initArray();
		int[] sortedByDefault = Arrays.copyOfRange(array, 0, array.length);
		Arrays.sort(sortedByDefault);
		SortAlgorithms.selectionSort(array);		
		assertTrue(Arrays.equals(array, sortedByDefault));
		
	}
	
	@Test
	public void testBubbleSort() {
		initArray();
		int[] sortedByDefault = Arrays.copyOfRange(array, 0, array.length);
		Arrays.sort(sortedByDefault);
		SortAlgorithms.bubbleSort(array);		
		assertTrue(Arrays.equals(array, sortedByDefault));
		
	}
	
	@Test
	public void testMergeSort() {
		initArray();
		int[] sortedByDefault = Arrays.copyOfRange(array, 0, array.length);
		Arrays.sort(sortedByDefault);
		SortAlgorithms.mergeSort(array);		
		assertTrue(Arrays.equals(array, sortedByDefault));
	}
	
	@Test
	public void testHeapSort() {
		initArray();
		int[] sortedByDefault = Arrays.copyOfRange(array, 0, array.length);
		Arrays.sort(sortedByDefault);
		SortAlgorithms.heapSort(array);		
		assertTrue(Arrays.equals(array, sortedByDefault));
	}
	

}
