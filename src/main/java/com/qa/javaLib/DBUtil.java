package com.qa.javaLib;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.testng.Reporter;

import com.qa.seleniumLib.TestData;



public class DBUtil extends DBConnection {

	public static List<Object> dataList = null;

	public static String data;

	// ----------------------------------------------------------------------------
	// This Method will delete user's ChatBot history
	// from specified database and user
	// ----------------------------------------------------------------------------
	public static void clearChatHistory(int dbType, String userEmail) {
		try {
			connection = DBConnection.getConnection(TestData.getEnviornment(), dbType);
			PreparedStatement ps = connection.prepareStatement("Global.clearChatHistoryQuery");
			ps.setString(1, userEmail);
			ps.executeUpdate();
			Reporter.log(TestData.getUserEmail() + " ChatBot History Cleared", true);
		} catch (SQLException e) {
			Reporter.log("Please Ensure, DB Connection is Correct and VPN is Connected", true);
			Reporter.log(e.getMessage(), true);
		} finally {
			closeConnection();
		}
	}

	// --------------------------------------------------------------------------------------------------------
	// This Method will take @param as dbType,query and column index
	// and return result set as list of Object
	// --------------------------------------------------------------------------------------------------------
	public static List<Object> getAll(int dbType, String query, int index) {
		dataList = new ArrayList<Object>();
		try {
			connection = DBConnection.getConnection(TestData.getEnviornment(), dbType);
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dataList.add(rs.getString(index));
			}
		} catch (SQLException e) {
			Reporter.log(e.getMessage(), true);
		} finally {
			closeConnection();
		}
		return dataList;
	}

	// --------------------------------------------------------------------------------------------------------
	// This Method will take @param as dbType, query and input
	// and return result set as list of Object
	// --------------------------------------------------------------------------------------------------------
	public static List<Object> getAll(int dbType, String query, String ip, int index) {
		dataList = new ArrayList<Object>();
		try {
			connection = DBConnection.getConnection(TestData.getEnviornment(), dbType);
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, ip);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dataList.add(rs.getString(index));
			}
		} catch (SQLException e) {
			Reporter.log(e.getMessage(), true);
		} finally {
			closeConnection();
		}
		return dataList;
	}

	// --------------------------------------------------------------------------------------------------------
	// This Method will take @param as dbType, query and 2-input
	// and return result set as list of Object
	// --------------------------------------------------------------------------------------------------------
	public static List<Object> getAll(int dbType, String query, String ip1, String ip2, int index) {
		dataList = new ArrayList<Object>();
		try {
			connection = DBConnection.getConnection(TestData.getEnviornment(), dbType);
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, ip1);
			ps.setString(2, ip2);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dataList.add(rs.getString(index));
			}
		} catch (SQLException e) {
			Reporter.log(e.getMessage(), true);
		} finally {
			closeConnection();
		}
		return dataList;
	}

	// ----------------------------------------------------------------------------------------------------------------
	// This Method will take @param as dbType, query, column and 3-input and
	// return result set as list of Object
	// ----------------------------------------------------------------------------------------------------------------
	public static List<Object> getAll(int dbType, String query, String ip1, String ip2, String ip3, String column) {
		dataList = new ArrayList<Object>();
		try {
			connection = DBConnection.getConnection(TestData.getEnviornment(), dbType);
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, ip1);
			ps.setString(2, ip2);
			ps.setString(3, ip3);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dataList.add(rs.getString(column));
			}
		} catch (SQLException e) {
			Reporter.log(e.getMessage(), true);
		} finally {
			closeConnection();
		}
		return dataList;
	}

	// --------------------------------------------------------------------------------------------------------
	// This Method will take @param as dbType, query and input index and then
	// provide result set
	// --------------------------------------------------------------------------------------------------------
	public static String get(int dbType, String query, int index) {
		data = null;
		try {
			connection = DBConnection.getConnection(TestData.getEnviornment(), dbType);
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				data = rs.getString(index);
			}
		} catch (SQLException e) {
			Reporter.log(e.getMessage(), true);
		} finally {
			closeConnection();
		}
		return data;
	}

	// --------------------------------------------------------------------------------------------------------
	// This Method will take @param as dbType, query and input and provide result
	// set
	// --------------------------------------------------------------------------------------------------------
	public static String get(int dbType, String query, String ip, int index) {
		data = null;
		try {
			connection = DBConnection.getConnection(TestData.getEnviornment(), dbType);
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, ip);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				data = rs.getString(index);
			}
		} catch (SQLException e) {
			Reporter.log(e.getMessage(), true);
		} finally {
			closeConnection();
		}
		return data;
	}

	// --------------------------------------------------------------------------------------------------------
	// This Method will take @param as dbType, query, 2-input and
	// column index and provide result set
	// --------------------------------------------------------------------------------------------------------
	public static String get(int dbType, String query, String ip1, String ip2, int index) {
		data = null;
		try {
			connection = DBConnection.getConnection(TestData.getEnviornment(), dbType);
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, ip1);
			ps.setString(2, ip2);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				data = rs.getString(index);
			}
		} catch (SQLException e) {
			Reporter.log(e.getMessage(), true);
		} finally {
			closeConnection();
		}
		return data;
	}

	// --------------------------------------------------------------------------------------------------------
	// This Method will take @param as dbType, query, 3-input and
	// column index and provide result set
	// --------------------------------------------------------------------------------------------------------
	public static String get(int dbType, String query, String ip1, String ip2, String ip3, int index) {
		data = null;
		try {
			connection = DBConnection.getConnection(TestData.getEnviornment(), dbType);
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, ip1);
			ps.setString(2, ip2);
			ps.setString(3, ip3);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				data = rs.getString(index);
			}
		} catch (SQLException e) {
			Reporter.log(e.getMessage(), true);
		} finally {
			closeConnection();
		}
		return data;
	}
}