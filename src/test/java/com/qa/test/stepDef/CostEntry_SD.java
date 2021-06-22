package com.qa.test.stepDef;

import com.qa.pages.CommonPage;
import com.qa.pages.CostEntryPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CostEntry_SD {

	CommonPage cPage;

	CostEntryPage cePage;

	public CostEntry_SD() {
		cPage = new CommonPage();
		cePage = new CostEntryPage();
		cPage.clickSearchProcess();
	}

	@Given("^CE: Open Process as \"([^\"]*)\"$")
	public void ce_Open_Cost_Entry_Process(String process) {
		cPage.openProcess(process);
	}

	@When("^CE: Click On Add$")
	public void ce_Click_On_Add() {
		cPage.clickAdd();
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
		cePage.enterTimekeeper(timekeeper);
	}

	@Then("^CE: Enter Quantity as \"([^\"]*)\"$")
	public void ce_Enter_Quantity_as(String quantity) {
		cePage.enterQuantity(quantity);
	}

	@Then("^CE: Enter Work Currency as \"([^\"]*)\"$")
	public void ce_Enter_Work_Currency_as(String currency) {
		cePage.enterCurrency(currency);
	}
	
	@Then("^CE: Enter Work Rate as \"([^\"]*)\"$")
	public void ce_Enter_Work_Rate_as(String workRate) {
		cePage.enterWorkRate(workRate);
	}

	@Then("^CE: Enter Narrative as \"([^\"]*)\"$")
	public void ce_Enter_Narrative_as(String narrative) {
		cePage.eneterNarrative(narrative);
	}

	@Then("^CE: Click on PostAll$")
	public void ce_Click_on_PostAll() {
		cePage.postAll();
	}

	@Then("^CE: Validate Home Page is Displayed$")
	public void ce_Validate_Home_Page_is_Displayed() {
		String home_page_text = cPage.getText();
		//System.out.println("home_page_text: " + home_page_text);
	}

}
