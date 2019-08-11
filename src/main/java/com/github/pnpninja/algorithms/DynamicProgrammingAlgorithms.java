package com.github.pnpninja.algorithms;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

public class DynamicProgrammingAlgorithms {
	/**
	 * Returns the minimum edit distance of two string
	 * @param s1 First String
	 * @param s2 Second String
	 * @return Minimum edit distance of the above two strings
	 */
	public static int minimumEditDistance(String s1, String s2) {
		char[] s1Array = s1.toCharArray();
		char[] s2Array = s2.toCharArray();
		return minimumEditDistanceInternal(s1Array, s2Array,s1Array.length,s2Array.length);
	}
	
	private static int minimumEditDistanceInternal(char[] s1,char[] s2,int s1Index,int s2Index) {
		if(s1Index==0) return s2Index;
		if(s2Index==0) return s1Index;
		if(s1[s1Index-1]==s2[s2Index-1]) return minimumEditDistanceInternal(s1,s2,s1Index-1,s2Index-1);
								//Replace operation
		return 1 + Math.min(	minimumEditDistanceInternal(s1,s2,s1Index-1,s2Index-1), 
								//Remove operation
					Math.min(	minimumEditDistanceInternal(s1,s2,s1Index-1,s2Index), 
								//Insert Operation
								minimumEditDistanceInternal(s1,s2,s1Index,s2Index-1)));
	}
	
	/**
	 * Returns the median of 2 arrays
	 * @param l1 1st Array
	 * @param l2 2nd Array
	 * @return Median of 2 sorted arrays
	 */
	
	public static double medianOfTwoArrays(List<Integer> l1, List<Integer> l2) {
		
		int[] array1 = ArrayUtils.toPrimitive(l1.toArray(new Integer[l1.size()]));
		int[] array2 = ArrayUtils.toPrimitive(l2.toArray(new Integer[l2.size()]));
		Arrays.sort(array1);
		Arrays.sort(array2);
		if(array1.length>array2.length) {
			return medianOfTwoSortedArrays(array2, array1);
		}
		return medianOfTwoSortedArrays(array1, array2);

	}
	
	private static double medianOfTwoSortedArrays(int[] array1,int[] array2) {
		 int lowArray1 = 0;
		 int highArray1 = array1.length;
		 while(lowArray1<=highArray1) {
			 int partitionArray1 = (lowArray1 + highArray1)/2;
			 int partitionArray2 = ((array1.length+array2.length+1)/2) - partitionArray1;
			 int minArray1 = partitionArray1==0? Integer.MIN_VALUE : array1[partitionArray1-1];
			 int maxArray1 = partitionArray1==array1.length?Integer.MAX_VALUE : array1[partitionArray1];
			 
			 int minArray2 = partitionArray2==0? Integer.MIN_VALUE : array2[partitionArray2-1];
			 int maxArray2 = partitionArray2==array2.length?Integer.MAX_VALUE : array2[partitionArray2];
			 
			 if(minArray1<=maxArray2 && minArray2<=maxArray1) { //Termination condition
				 if((array1.length+array2.length)%2==0) {				
					 return ArithmeticUtils.avg(
							 ArithmeticUtils.max(minArray1, minArray2),
							 ArithmeticUtils.min(maxArray1, maxArray2));
				 }else {
					 return (double)ArithmeticUtils.max(minArray1, minArray2);
				 }
			 }else if(minArray1>maxArray2) {
				 highArray1 = partitionArray1 - 1;
			 }else {
				 lowArray1 = partitionArray1 + 1;
			 }
		 }
		 throw new IllegalArgumentException();
	}
	
}
