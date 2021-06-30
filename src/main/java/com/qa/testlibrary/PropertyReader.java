package com.qa.testlibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;


public class PropertyReader 
{

	public static Properties prop;

	public  WebDriver driver;
	

	public static String readProperty(String key)
	{
		PropertyReader.init();
		String value = prop.getProperty(key);
		return value;
	}
	
	
	public static void init()
	{
		prop = new Properties();
		try
		{
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Config/config.properties");
			prop.load(ip);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
}
