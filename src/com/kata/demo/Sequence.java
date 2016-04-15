/*
*Copyright (c) 2016, gp.inc and/or its affiliates. All rights reserved.
*/
package com.kata.demo;

public class Sequence { 
	public static final long BASE = 50;
	
	public static long getScore(long n) {
		long sum = 0;
		for (long i = n; i > 0; i--) {
			sum += i;
		}
		return sum * BASE;
	}
}
