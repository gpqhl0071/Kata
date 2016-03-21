/*
*Copyright (c) 2016, gp.inc and/or its affiliates. All rights reserved.
*/
package com.kata.properties.demo;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesDemo {
	/**
	 * 读取properties方法
	 * @author: gao peng   
	 * @param: @param name
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	private static String getProperty(String name) {
		String rule = "";
		Properties prop = new Properties();
		InputStream in = PropertiesDemo.class.getResourceAsStream("/properties/kafka.properties");
		try {
			prop.load(in);
			rule = prop.getProperty(name);
		} catch (Exception e) {
			System.out.println("警告！！！警告！！！未读取到properties配置文件!!!!!!");
			return "";
		}
		return rule;
	}

	public static void main(String[] args) {
		System.out.println(getProperty("TEST"));
	}
}
