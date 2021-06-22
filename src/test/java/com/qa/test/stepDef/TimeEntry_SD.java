package com.qa.test.stepDef;

import com.qa.pages.TimeEntryPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TimeEntry_SD {

	private static TimeEntryPage tePage;

	public TimeEntry_SD() {
		tePage = new TimeEntryPage();
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
		System.out.println("validate_Home_Page_is_Displayed");
		// String homePageText=tePage.getText();
		// System.out.println("Home Page Text is: "+homePageText);
	}

}
