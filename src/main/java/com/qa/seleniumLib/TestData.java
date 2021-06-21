package com.qa.seleniumLib;


public class TestData {

	public static String getEnviornment() {
		return PropertyReader.readProperty("Environment");
		// return System.getProperty("Environment");
	}

	public static String getExecutionType() {
		return PropertyReader.readProperty("ExecutionType");
		// return System.getProperty("ExecutionType");

	}

	public static String getBrowser() {
		return PropertyReader.readProperty("Browser");
	}

	public static String getURL() {
		return PropertyReader.readProperty("URL");
		// return System.getProperty("URL");
	}

	public static String getUserEmail() {
		return PropertyReader.readProperty("UserEmail");
		// return System.getProperty("UserEmail");
	}

	public static String getPassword() {
		return PropertyReader.readProperty("Password");
		// return System.getProperty("Password");
	}

	public static String getScreenshotPath() {
		return "http://192.168.1.195:8080/job/" + System.getProperty("Project") + "/ws/Screenshots/";
	}

	
}