package com.qa.test.stepDef.pageTests;

import com.qa.pages.TimeEntryPage;
import com.qa.test.stepDef.hooks.ServiceHooks;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TimeEntry_SD {

	TimeEntryPage tePage;

	public TimeEntry_SD() {
		System.out.println("TimeEntry_SD --------------------1");
		new ServiceHooks();
		System.out.println("TimeEntry_SD --------------------2");
	}

	@Before(order = 1, value = "@TimeEntry")
	public void setUp() {
		System.out.println("setUp --------------------");
		tePage=new TimeEntryPage();
		tePage.clickSearchProcess();
	}

	@Given("^Open Time Entry Process$")
	public void open_Time_Entry_Process() {
		System.out.println("open_Time_Entry_Process");
		tePage.openProcess("Time Entry");
	}

	@When("^Click On Add$")
	public void click_On_Add() {
		System.out.println("click_On_Add");
		tePage.clickAdd();
	}

	@Then("^Enter Timekeeper Number as \"([^\"]*)\"$")
	public void verify_Time_Entry_Form(String timekeeper) {
		System.out.println("verify_Time_Entry_Form");
		String text=tePage.getHeader();
		System.out.println("text:--------"+text);
		tePage.enterTkpNumber(timekeeper);
	}

	@Then("^Enter Matter Number as \"([^\"]*)\"$")
	public void enter_Matter_Number(String matter) {
		System.out.println("enter_Matter_Number");
		tePage.enterMatter(matter);
	}

	@Then("^Select Time Type as \"([^\"]*)\"$")
	public void select_Time_Type(String timeType) {
		System.out.println("select_Time_Type");
		tePage.enterTimeType(timeType);
	}

	@Then("^Enter Hours as \"([^\"]*)\"$")
	public void enter_Hours(String hours) {
		System.out.println("enter_Hours");
		tePage.enterHours(hours);
	}

	@Then("^Enter Narrative as \"([^\"]*)\"$")
	public void enter_Narrative(String narrative) {
		System.out.println("enter_Narrative");
		tePage.enterNarrative(narrative);
	}

	@Then("^Click on PostAll$")
	public void click_on_PostAll() {
		System.out.println("click_on_PostAll");
		tePage.ClickPostAll();
	}

	@Then("^Validate Home Page is Displayed$")
	public void validate_Home_Page_is_Displayed() {
		System.out.println("validate_Home_Page_is_Displayed");
		String homePageText=tePage.getText();
		System.out.println("Home Page Text is: "+homePageText);
	}

}
