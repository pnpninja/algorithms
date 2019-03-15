package com.github.pnpninja.algorithms;

import static org.junit.Assert.assertTrue;

import java.lang.annotation.Repeatable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.junit.Test;

import com.google.common.primitives.Ints;

import sun.reflect.generics.tree.IntSignature;

public class DynamicProgrammingAlgorithmsTest {
	
	@Test
	public void testMinimumEditDistance() {
		String s1 = "sunday";
		String s2 = "saturday";
		assertTrue(DynamicProgrammingAlgorithms.minimumEditDistance(s1, s2)==3);
	}
	
	@Test
	public void testMedianOfTwoArrays() {
		for (int a = 0; a < 150; a++) {
			List<Integer> array1 = Ints.asList(initArray());
			List<Integer> array2 = Ints.asList(initArray());
			List<Integer> array3 = new ArrayList<Integer>(array1);
			array3.addAll(array2);

			Collections.sort(array3);
			double median;
			if (array3.size() % 2 == 0)
				median = ((double) array3.get(array3.size() / 2) + (double) array3.get(array3.size() / 2 - 1)) / 2;
			else
				median = (double) array3.get(array3.size() / 2);
			assertTrue(DynamicProgrammingAlgorithms.medianOfTwoArrays(array1, array2) == median);
		}
	}
	
	public int[] initArray() {
		int[] array = new int[10000];
		Random random = new Random();
		for (int i = 0; i < 10000; i++)
		{
			array[i] = random.nextInt(1000);
		}
		return array;
	}

}
