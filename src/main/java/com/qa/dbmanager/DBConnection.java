package com.qa.dbmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection connection = null;

	public static Connection getConnection(String environment) {

		String dbURL = null;
		String userName = null;
		String password = null;

		// 1.To Get Production Database Connection :
		if (environment.equalsIgnoreCase("prod")) {
			dbURL = DBConstant.dbURL_Prod;
			userName = DBConstant.dbUser_Prod;
			password = DBConstant.dbPwd_Prod;
		}

		// 1.To Get Staging Database Connection :
		else if (environment.equalsIgnoreCase("stage")) {
			dbURL = DBConstant.dbURL_Stage;
			userName = DBConstant.dbUser_Stage;
			password = DBConstant.dbPwd_Stage;
		} else {
			org.testng.Reporter.log("Database Environment Not Found", true);
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
