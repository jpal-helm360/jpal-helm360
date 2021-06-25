package com.qa.testlibrary;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public static WebDriver driver=null;

	public DriverFactory() {
		
	}
	
	public static WebDriver getDriver() {
		ChromeOptions option = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		option.addArguments("--incognito");
		option.addArguments("start-maximized");
		driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
		
	/*public void doLogin() {
		driver=getDriver();
		driver.get(TestData.getURL());
		try {
			Thread.sleep(7000);
			Runtime.getRuntime().exec(System.getProperty("user.dir") + "/src/test/resources/Autoit/3EAuthencation.exe");
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}*/
	
}
