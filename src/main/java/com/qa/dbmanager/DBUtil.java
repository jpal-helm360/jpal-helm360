package com.qa.dbmanager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Reporter;

import com.qa.testLib.TestDataManager;

public class DBUtil extends DBConnection {

	public static List<Object> dataList = null;

	public static String data;

	// -------------------------------------------------------------------------------------
	// This Method will take @param as query and column index
	// and return result set as list of Object
	// --------------------------------------------------------------------------------------
	public static List<Object> getAll(String query, int index) {
		dataList = new ArrayList<Object>();
		try {
			connection = DBConnection.getConnection(TestDataManager.getEnviornment());
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

	// ----------------------------------------------------------------------------------------
	// This Method will take @param as dbType, query and input
	// and return result set as list of Object
	// ----------------------------------------------------------------------------------------
	public static List<Object> getAll(String query, String ip, int index) {
		dataList = new ArrayList<Object>();
		try {
			connection = DBConnection.getConnection(TestDataManager.getEnviornment());
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

	// ------------------------------------------------------------------------------------------
	// This Method will take @param as query and input index and then
	// provide result set
	// ------------------------------------------------------------------------------------------
	public static String get(String query, int index) {
		data = null;
		try {
			connection = DBConnection.getConnection(TestDataManager.getEnviornment());
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

	// -----------------------------------------------------------------------------------------
	// This Method will take @param as query and input and provide result set
	// -----------------------------------------------------------------------------------------
	public static String get(String query, String ip, int index) {
		data = null;
		try {
			connection = DBConnection.getConnection(TestDataManager.getEnviornment());
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

}
