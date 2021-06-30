package com.qa.test.demo;

import org.openqa.selenium.WebDriver;

import com.qa.dbmanager.DBUtil;

public class Test {

	WebDriver driver;

	@org.testng.annotations.Test
	public void testLogin() { 
		String data=DBUtil.get("select top 1 InvNumber from InvMaster order by timestamp desc", 1);
		System.out.println("data is:---------------->>> "+data);
	}

}
