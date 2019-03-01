package com.github.pnpninja.algorithms;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DynamicProgrammingAlgorithmsTest {
	
	@Test
	public void testMinimumEditDistance() {
		String s1 = "sunday";
		String s2 = "saturday";
		assertTrue(DynamicProgrammingAlgorithms.minimumEditDistance(s1, s2)==3);
	}

}
