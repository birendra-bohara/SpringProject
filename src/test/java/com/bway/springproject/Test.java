package com.bway.springproject;

import static org.junit.Assert.assertEquals;

import testing.Calculation;

public class Test {

	
	
	
	@org.junit.Test
	public void testSquare() {
		Calculation cal = new Calculation();
		int result = cal.square(5);
		assertEquals(25, result);
	}
	
	@org.junit.Test
	public void testSum() {
		Calculation cal=new Calculation();
		int result=cal.sum(5, 4);
		assertEquals(9, result);
	}
	
	
}
