package com.qa.test.demo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import javax.xml.transform.Source;
import org.openqa.selenium.WebDriver;
import com.qa.dbmanager.DBUtil;
import com.qa.testlibrary.JavaUtil;

public class Test {

	WebDriver driver;

	@org.testng.annotations.Test
	public void testLogin() { 
		//String data=DBUtil.get("select top 1 InvNumber from InvMaster order by timestamp desc", 1);
		//System.out.println("data is:---------------->>> "+data);
		
		System.out.println(JavaUtil.getYesterdayDate());
		
	}

}
