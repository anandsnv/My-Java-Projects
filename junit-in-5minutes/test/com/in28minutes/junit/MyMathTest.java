package com.in28minutes.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.in28minutes.MyMath;

class MyMathTest {

	@Test
	void sum_with3numbers() {
		MyMath myMath=new MyMath();
		int result = myMath.sum(new int[] {1,2,3});
		assertEquals(6,result);
		System.out.println(result);
		
	}

}
