package com.qa.test.stepDef;


import java.io.IOException;
import com.qa.seleniumLib.SeleniumUtil;
import com.qa.seleniumLib.TestData;
import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class ServiceHooks extends com.qa.base.BaseTest {

	Scenario scenario;

	// 1.Create the public method
	// 2. Use the @Before & @After annotations with the methods
	// 3. Specify the package in the runner
	// 4. Inject the Scenario Object in the hook method

	@Before(order = 0)
	public void setUp(Scenario scenario) {
		this.scenario = scenario;
		System.out.println("Scenario is ---> " + this.scenario.getName());
		doLogin();
		new SeleniumUtil().iSleep();
		System.out.println("Login Done");
	}

	@After
	public void quitDriver(Scenario scenario) throws IOException {
		this.scenario = scenario;
		String scenarioName = scenario.getName();
		if (scenario.isFailed()) {
			System.out.println("Falied Scenario Name Is: " + scenarioName);
			scenario.write("Current URL is : " + driver.getCurrentUrl());
			Reporter.addScreenCaptureFromPath(SeleniumUtil.takeScreenshotPath(driver, scenarioName));
		} else {
			System.out.println("Pass Scenario Name Is: " + scenarioName);
		}
		Reporter.assignAuthor("Jaydeep");
		Reporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
		Reporter.setSystemInfo("Environment", TestData.getEnviornment());
		Reporter.setSystemInfo("ExecutionType", TestData.getExecutionType());
		Reporter.setSystemInfo("User", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time-Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Machine", "Windows 10" + " " + "64 Bit");
		Reporter.setSystemInfo("Selenium", "3.7.0");
		Reporter.setSystemInfo("Maven", "3.5.2");
		Reporter.setSystemInfo("Java-Version", "1.8.0_151");
		Reporter.setSystemInfo("URL", TestData.getURL());
		Reporter.getExtentReport();
		//driver.quit();
	}
}