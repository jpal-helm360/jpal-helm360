package com.qa.test.runner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.seleniumLib.TestData;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;


@CucumberOptions(features = { "src/test/resources/Features" },	
		glue = { "com.qa.test.stepDef", "com.qa.seleniumLib","com.qa.pages" },
		plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:./Report/TermiExtent.html" },
		monochrome = true,
		dryRun =false
		,tags= {"@CostEntry"}
		)

public class TestRunner {
	
	@BeforeClass
	public void test() {
		System.out.println("===================>>>Execution Enviornment: "+TestData.getEnviornment());
	}

	@Test
	public void runCukes() {
		new TestNGCucumberRunner(getClass()).runCukes();
	}
	
}