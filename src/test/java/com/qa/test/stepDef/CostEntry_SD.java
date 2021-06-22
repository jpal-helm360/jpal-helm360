package com.qa.test.stepDef;

import static org.testng.Assert.assertEquals;
import com.qa.pages.CostEntryPage;
import com.qa.seleniumLib.PropertyReader;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CostEntry_SD {

	CostEntryPage cePage;

	public CostEntry_SD() {
		new ServiceHooks();
	}

	@Before(order = 1, value = "@CostEntry")
	public void setUp() {
		cePage = new CostEntryPage();
		cePage.clickSearchProcess();
	}

	@Given("^CE: Open Process as \"([^\"]*)\"$")
	public void ce_Open_Cost_Entry_Process(String process) {
		cePage.openProcess(process);
	}

	@When("^CE: Click On Add$")
	public void ce_Click_On_Add() {
		cePage.clickAdd();
	}

	@Then("^CE: Enter Cost Type \"([^\"]*)\"$")
	public void ce_Enter_Cost_Type(String costType) {
		cePage.enterCostType(costType);
	}

	@Then("^CE: Enter Matter Number as \"([^\"]*)\"$")
	public void ce_Enter_Matter_Number_as(String matter) {
		cePage.enterMatter(matter);
	}

	@Then("^CE: Enter Timekeeper Number as \"([^\"]*)\"$")
	public void ce_Enter_Timekeeper_Number_as(String timekeeper) {
		cePage.enterTkpNumber(timekeeper);
	}

	@Then("^CE: Enter Quantity as \"([^\"]*)\"$")
	public void ce_Enter_Quantity_as(String quantity) {
		cePage.enterQuantity(quantity);
	}

	@Then("^CE: Enter Work Currency as \"([^\"]*)\"$")
	public void ce_Enter_Work_Currency_as(String currency) {
		cePage.enterWorkCurrency(currency);
	}
	
	@Then("^CE: Enter Work Rate as \"([^\"]*)\"$")
	public void ce_Enter_Work_Rate_as(String rate) {
		cePage.enterWorkRate(rate);
	}

	@Then("^CE: Enter Narrative as \"([^\"]*)\"$")
	public void ce_Enter_Narrative_as(String narrative) {
		cePage.enterNarrative(narrative);
	}

	@Then("^CE: Click on PostAll$")
	public void ce_Click_on_PostAll() {
		cePage.ClickPostAll();
	}

	@Then("^CE: Validate Home Page is Displayed$")
	public void ce_Validate_Home_Page_is_Displayed() {
		String actualHomePageText=PropertyReader.readProperty("homePageText");
		assertEquals(actualHomePageText, cePage.getText(),"Home Page Text Not Verified");
	}

}
