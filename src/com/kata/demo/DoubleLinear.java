/*
*Copyright (c) 2016, gp.inc and/or its affiliates. All rights reserved.
*/
package com.kata.demo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author: gao peng
 * @date: 2016年5月13日 下午5:20:20
 *
 */
public class DoubleLinear {

	static List<Integer> list;
	static Map<Integer, Integer> map;

	public static int dblLinear(int n) {
		list = new LinkedList<Integer>();
		map = new HashMap<Integer, Integer>();
		int base = 1;

		map.put(base, base);
		list.add(1);
		while (list.size() < n) {
			execute();
		}

		return list.get(n);
	}

	public static void execute() {
		Map<Integer, Integer> nextMap = new HashMap<Integer, Integer>();
		for (Integer value : map.values()) {
			// 2*n+1
			int a = 2 * value + 1;
			// 3*n+1
			int b = 3 * value + 1;
			nextMap.put(a, a);
			nextMap.put(b, b);
		}

		Map<Integer, Integer> cloneNextMap = new HashMap<Integer, Integer>();
		cloneNextMap.putAll(nextMap);
		for (Integer min : nextMap.values()) {
			for (Integer value : cloneNextMap.values()) {
				if (min > value) {
					min = value;
				}
			}
			cloneNextMap.remove(min);
			list.add(min);
		}

		map.clear();
		map.putAll(nextMap);
	}

	public static void main(String[] args) {
//		System.out.println(dblLinear(10));
		System.out.println(dblLinear(20));
		System.out.println(dblLinear(30));
	}
}
