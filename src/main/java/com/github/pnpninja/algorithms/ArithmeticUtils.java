package com.github.pnpninja.algorithms;

class ArithmeticUtils {
	
	public static int min(int a,int b) {
		return a<b?a:b;
	}
	
	public static int max(int a,int b) {
		return a>b?a:b;
	}
	
	public static double avg(int...a) {
		int sum = 0;
		for (int elem : a) {
			sum+=elem;
		}
		return ((double)sum)/(a.length);
		
	}

}
