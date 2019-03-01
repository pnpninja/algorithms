package com.github.pnpninja.algorithms;

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
}
