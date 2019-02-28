package com.github.pnpninja.algorithms.arrays;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class SortAlgorithmsTest {
	
	int[] array = new int[10000];
	
	@Before
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
		SortAlgorithms.insertionSort(array);
		assertTrue(isArrayInOrder(array));
		
	}
	
	@Test
	public void testSelectionSort() {
		initArray();
		SortAlgorithms.selectionSort(array);
		assertTrue(isArrayInOrder(array));
		
	}
	
	boolean isArrayInOrder(int[] array) {
		for(int index = 1;index<array.length;index++) {
			if(array[index]<array[index-1]) {
				return false;
			}
		}
		return true;
	}

}
