package com.kata.demo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DoubleLinear {

	static List<Integer> list;
	static Map<Integer, Integer> map;

	public static int dblLinear(int n) {
		list = new LinkedList<Integer>();
		map = new HashMap<Integer, Integer>();
		int base = 1;

		map.put(base, base);
		list.add(1);
		while (list.size() <= n * 2) {
			execute();
		}

		sort(list);
		return list.get(n);
	}

	public static void execute() {
		Map<Integer, Integer> nextMap = new HashMap<Integer, Integer>();
		for (Integer value : map.values()) {
			// 2*n+1
			int a = 2 * value + 1;
			// 3*n+1
			int b = 3 * value + 1;
			if (!nextMap.containsKey(a)) {
				nextMap.put(a, a);
			}
			if (!nextMap.containsKey(b)) {
				nextMap.put(b, b);
			}
		}

		Map<Integer, Integer> cloneNextMap = new HashMap<Integer, Integer>();
		cloneNextMap.putAll(nextMap);

		addList(nextMap);

		map.clear();
		map.putAll(nextMap);
	}

	public static void main(String[] args) {
		System.out.println(dblLinear(10));
		System.out.println(dblLinear(20));
		System.out.println(dblLinear(30));
		System.out.println(dblLinear(50));
	}

	public static void addList(Map<Integer, Integer> map) {
		Integer[] values = new Integer[map.size()];
		int num = 0;
		for (Integer value : map.values()) {
			values[num] = value;
			num++;
		}

		for (int i = 0; i < values.length; i++) {
			if (list.contains(values[i])) {
				continue;
			}
			list.add(values[i]);
		}

	}

	public static void sort(List<Integer> l) {
		int[] values = new int[l.size()];
		for (int i = 0; i < l.size(); i++) {
			values[i] = l.get(i);
		}

		l.clear();
		int temp = 0;
		for (int i = 0; i < values.length - 1; i++) {
			for (int j = i + 1; j < values.length; j++) {
				if (values[i] > values[j]) {
					temp = values[i];
					values[i] = values[j];
					values[j] = temp;
				}
			}
		}

		for (int i = 0; i < values.length; i++) {
			list.add(values[i]);
		}
		System.out.println(list.toString());
	}
}
