package com.dreamcode.utils;

public class DBHandler {
	
	private static DBHandler instance;
	public static DBHandler getInstnace() {
		if (instance == null) {
			instance = new DBHandler();
		}
		return instance;
	}
	
	

}
