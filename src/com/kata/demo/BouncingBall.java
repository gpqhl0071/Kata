/*
*Copyright (c) 2016, gp.inc and/or its affiliates. All rights reserved.
*/
package com.kata.demo;

public class BouncingBall {

	public static int bouncingBall(double h, double bounce, double window) {
		System.out.println("h=" + h + ",bounce=" + bounce + ",window=" + window);
		if (bounce >= 1 || h < 0 || bounce < 0 || window < 0 || h == window) {
			return -1;
		}
		// 至少看到一次
		int ballDownTimes = 1;
		while (true) {
			h = h * bounce;
			if (h > window) {
				ballDownTimes += 2;
			} else {
				break;
			}
		}

		return ballDownTimes;
	}

	public static void main(String[] args) {
		System.out.println(bouncingBall(3.0, 0.66, 1.5));
		System.out.println(bouncingBall(30.0, 0.66, 1.5));
	}
}
