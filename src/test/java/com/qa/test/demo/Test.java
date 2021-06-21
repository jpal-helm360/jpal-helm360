package com.qa.test.demo;


import org.openqa.selenium.WebDriver;
import com.qa.seleniumLib.TestData;

public class Test {
	
	WebDriver driver;
	
	@org.testng.annotations.Test
	public void testLogin() throws InterruptedException {
		/*driver = BaseTest.getDriver();
		driver.get(BaseTest.getURL());
		Thread.sleep(5000);
		try {
			Runtime.getRuntime().exec(System.getProperty("user.dir") + "/src/test/resources/Autoit/3EAuthencation.exe");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='search-button']//mat-icon")).click();*/
		//TestData td=new TestData();
		System.out.println(TestData.getEnviornment());
		
	}
	

}
