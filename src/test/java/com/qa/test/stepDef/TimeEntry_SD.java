package com.qa.test.stepDef;

import static org.testng.Assert.assertEquals;
import com.qa.pages.TimeEntryPage;
import com.qa.testlibrary.PropertyReader;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TimeEntry_SD {

	TimeEntryPage tePage;

	public TimeEntry_SD() {
		new ServiceHooks();
	}

	@Before(order = 1, value = "@TimeEntry")
	public void setUp() {
		tePage=new TimeEntryPage();
		tePage.clickSearchProcess();
	}

	@Given("^Open Time Entry Process$")
	public void open_Time_Entry_Process() {
		tePage.openProcess("Time Entry");
	}

	@When("^Click On Add$")
	public void click_On_Add() {
		tePage.clickAdd();
	}

	@Then("^Enter Timekeeper Number as \"([^\"]*)\"$")
	public void verify_Time_Entry_Form(String timekeeper) {
		tePage.enterTkpNumber(timekeeper);
	}

	@Then("^Enter Matter Number as \"([^\"]*)\"$")
	public void enter_Matter_Number(String matter) {
		tePage.enterMatter(matter);
	}

	@Then("^Select Time Type as \"([^\"]*)\"$")
	public void select_Time_Type(String timeType) {
		tePage.enterTimeType(timeType);
	}

	@Then("^Enter Hours as \"([^\"]*)\"$")
	public void enter_Hours(String hours) {
		tePage.enterHours(hours);
	}

	@Then("^Enter Narrative as \"([^\"]*)\"$")
	public void enter_Narrative(String narrative) {
		tePage.enterNarrative(narrative);
	}

	@Then("^Click on PostAll$")
	public void click_on_PostAll() {
		tePage.ClickPostAll();
	}

	@Then("^Validate Home Page is Displayed$")
	public void validate_Home_Page_is_Displayed() {
		String homePageText=PropertyReader.readProperty("homePageText");
		assertEquals(homePageText, tePage.getText(),"Home Page Not Matched");
		
	}

}
