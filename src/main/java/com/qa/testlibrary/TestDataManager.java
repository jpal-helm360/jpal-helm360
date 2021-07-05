package com.qa.testlibrary;

public class TestDataManager {

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

	public static String getDBUrl() {
		if (getEnviornment().equals("stage")) {
			return PropertyReader.readProperty("dbURL_Stage");
		} else if (getEnviornment().equals("prod")) {
			return null;
		} else {
			return null;
		}
	}

	public static String getDBUser() {
		if (getEnviornment().equals("stage")) {
			return PropertyReader.readProperty("dbUser_Stage");
		} else if (getEnviornment().equals("prod")) {
			return null;
		} else {
			return null;
		}
	}

	public static String getDBPassword() {
		if (getEnviornment().equals("stage")) {
			return PropertyReader.readProperty("dbPwd_Stage");
		} else if (getEnviornment().equals("prod")) {
			return null;
		} else {
			return null;
		}
	}

}