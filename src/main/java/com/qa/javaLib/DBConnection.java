package com.qa.javaLib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {

	public static Connection connection = null;

	public static Connection getConnection(String environment, int dbType) {

		String dbURL = null;
		String userName = null;
		String password = null;

		// 1.To Get Application Database Connection on Sales Environment :
		if (environment.equalsIgnoreCase("sales") && dbType == 1) {
			dbURL = DBConstant.AppDBURL_Sales;
			userName = DBConstant.AppDBUser_Sales;
			password = DBConstant.AppDBPwd_Sales;
		}

		// 2.To Get Application Database Connection on Staging Environment :
		else if (environment.equalsIgnoreCase("staging") && dbType == 1) {
			dbURL = DBConstant.AppDBURL_Staging;
			userName = DBConstant.AppDBUser_Staging;
			password = DBConstant.AppDBPwd_Staging;
		}

		// 3.To Get Application Database Connection on QA Environment :
		else if (environment.equalsIgnoreCase("qa") && dbType == 1) {
			System.out.println("Need To Provide QA DB Credentail: ");
		}

		// 4.To Get Warehouse_1 Database Connection on Sales Environment :
		else if (environment.equalsIgnoreCase("sales") && dbType == 2) {
			dbURL = DBConstant.WHDBURL1_Sales;
			userName = DBConstant.WHDBUser1_Sales;
			password = DBConstant.WHDBPwd1_Sales;
		}

		// 5.To Get Warehouse_1 Database Connection on Staging Environment :
		else if (environment.equalsIgnoreCase("staging") && dbType == 2) {
			dbURL = DBConstant.WHDBURL1_Staging;
			userName = DBConstant.WHDBUser1_Staging;
			password = DBConstant.WHDBPwd1_Staging;
		}

		// 6.To Get Warehouse_1 Database Connection on QA Environment :
		else if (environment.equalsIgnoreCase("qa") && dbType == 2) {
			System.out.println("Need To Provide QA Database Details : ");
		}

		// 7.To Get Warehouse_2 Database Connection on Sales Environment :
		else if (environment.equalsIgnoreCase("sales") && dbType == 3) {
			dbURL = DBConstant.WHDBURL2_Sales;
			userName = DBConstant.WHDBUser2_Sales;
			password = DBConstant.WHDBPwd2_Sales;
		}

		// 8.To Get Warehouse_2 Database Connection on Staging Environment :
		else if (environment.equalsIgnoreCase("staging") && dbType == 3) {
			dbURL = DBConstant.WHDBURL2_Staging;
			userName = DBConstant.WHDBUser2_Staging;
			password = DBConstant.WHDBPwd2_Staging;
		}

		// 9.To Get Warehouse_2 Database Connection on QA Environment :
		else if (environment.equalsIgnoreCase("qa") && dbType == 3) {
			System.out.println("Need To Provide QA Database Details : ");
		}

		else {
			org.testng.Reporter.log("Environment And DBType Not Matched ", true);
		}
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(dbURL, userName, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
