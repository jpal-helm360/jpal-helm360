package com.qa.testlibrary;


import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class JavaUtil {

	public static String convertDateFormat(String inputPattern, String outputPattern, String givenDate) {
		SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
		SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);
		Date date = null;
		String requiredDate = null;
		try {
			date = inputFormat.parse(givenDate);
			requiredDate = outputFormat.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return requiredDate;
	}

	
	// To get current time 
	public static String currentTimestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

	public static List<String> removeComma(List<String> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).contains(",")) {
				String value = list.get(i).replaceAll(",", "");
				list.set(i, value);
			}
		}
		return list;
	}

	public static String removeComma(String value) {
		if (value.contains(",")) {
			value = value.replace(",", "");
		}
		return value;
	}

	public static List<String> formatListStr(List<String> list) {
		DecimalFormat df = new DecimalFormat("#.##");
		String value = null;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).contains(",")) {
				value = df.format(Double.valueOf(list.get(i).replaceAll(",", "")));
				list.set(i, value);
			} else {
				value = df.format(Double.valueOf(list.get(i)));
				list.set(i, value);
			}
		}
		return list;
	}

	public static List<Object> format(List<Object> list) {
		DecimalFormat df = new DecimalFormat("#.##");
		String value = null;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).toString().contains(",")) {
				value = df.format(Double.valueOf(list.get(i).toString().replaceAll(",", "")));
				list.set(i, value);
			} else {
				value = df.format(Double.valueOf(list.get(i).toString()));
				list.set(i, value);
			}
		}
		return list;
	}

	public static Object format(Object value) {
		DecimalFormat df = new DecimalFormat("#.##");
		value = df.format(Double.valueOf(value.toString()));

		return value;
	}

	public static String splitString(String input, String regex, String index) {
		String arr[] = input.split(regex);
		int len = arr.length;
		String output = "";
		if (index.equalsIgnoreCase("first")) {
			output = arr[0];
		} else if (index.equalsIgnoreCase("last")) {
			output = arr[len - 1];
		}
		return output;
	}

	public static String removeSpace(String ip, String replacement) {
		ip = ip.replaceAll("[\n\r]+", replacement);
		return ip;
	}

}