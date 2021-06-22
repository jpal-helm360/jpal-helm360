package com.qa.test.stepDef.pageTests;

import com.qa.pages.CEPage;
import com.qa.test.stepDef.hooks.ServiceHooks;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CostEntry_SD2 {

	CEPage page;

	public CostEntry_SD2() {
		System.out.println("CostEntry_SD --------------------1");
		new ServiceHooks();
		System.out.println("CostEntry_SD --------------------2");
	}

	@Before(order = 1, value = "@CostEntry")
	public void setUp() {
		System.out.println("setUp --------------------");
		page = new CEPage();
		page.clickSearchProcess();
	}

	@Given("^CE: Open Process as \"([^\"]*)\"$")
	public void ce_Open_Cost_Entry_Process(String process) {
		page.openProcess(process);
	}

	@When("^CE: Click On Add$")
	public void ce_Click_On_Add() {
		page.clickAdd();
	}

	@Then("^CE: Enter Cost Type \"([^\"]*)\"$")
	public void ce_Enter_Cost_Type(String costType) {
		page.enterCostType(costType);
	}

	@Then("^CE: Enter Matter Number as \"([^\"]*)\"$")
	public void ce_Enter_Matter_Number_as(String matter) {
		page.enterMatter(matter);
	}

	@Then("^CE: Enter Timekeeper Number as \"([^\"]*)\"$")
	public void ce_Enter_Timekeeper_Number_as(String timekeeper) {
		page.enterTkpNumber(timekeeper);
	}

	@Then("^CE: Enter Quantity as \"([^\"]*)\"$")
	public void ce_Enter_Quantity_as(String quantity) {
		page.enterQuantity(quantity);
	}

	@Then("^CE: Enter Work Currency as \"([^\"]*)\"$")
	public void ce_Enter_Work_Currency_as(String currency) {
		page.enterWorkCurrency(currency);
	}
	
	@Then("^CE: Enter Work Rate as \"([^\"]*)\"$")
	public void ce_Enter_Work_Rate_as(String rate) {
		page.enterWorkRate(rate);
	}

	@Then("^CE: Enter Narrative as \"([^\"]*)\"$")
	public void ce_Enter_Narrative_as(String narrative) {
		page.enterNarrative(narrative);
	}

	@Then("^CE: Click on PostAll$")
	public void ce_Click_on_PostAll() {
		page.ClickPostAll();
	}

	@Then("^CE: Validate Home Page is Displayed$")
	public void ce_Validate_Home_Page_is_Displayed() {
		String home_page_text = page.getText();
		System.out.println("home_page_text: " + home_page_text);
	}

}
