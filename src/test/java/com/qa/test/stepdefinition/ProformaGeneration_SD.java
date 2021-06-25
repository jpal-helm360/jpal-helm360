package com.qa.test.stepdefinition;

import com.qa.pages.ProformaGenerationPage;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProformaGeneration_SD {

	private static ProformaGenerationPage pgPage;

	public ProformaGeneration_SD() {
		pgPage = new ProformaGenerationPage();
	}

	@Before(order = 1, value = "@ProformaGeneration")
	public void setUp() {

	}

	@Given("^PG: Open Proforma Generation Process$")
	public void pg_Open_Proforma_Generation_Process() {

	}

	@When("^PG: Click On Add Proforma Generation$")
	public void pg_Click_On_Add_Proforma_Generation() {

	}

	@When("^PG: Enter Description$")
	public void pg_Enter_Description() {

	}

	@Then("^PG: Clear Reset Dates Using Field$")
	public void pg_Clear_Reset_Dates_Using_Field() {

	}

	@Then("^PG: Uncheck Inclues Entries on Other Proforma$")
	public void pg_Uncheck_Inclues_Entries_on_Other_Proforma() {

	}

	@Then("^PG: Select Yesterday date in Time Start$")
	public void pg_Select_Yesterday_date_in_Time_Start() {

	}

	@Then("^PG: Select Yesterday date in Cost Start$")
	public void pg_Select_Yesterday_date_in_Cost_Start() {

	}

	@Then("^PG: Select Yesterday date in Charge Start$")
	public void pg_Select_Yesterday_date_in_Charge_Start() {

	}

	@Then("^PG: Click Three Dot$")
	public void pg_Click_Three_Dot() {

	}

	@Then("^PG: Navigate to Proforma Generaton Child Form$")
	public void pg_Navigate_to_Proforma_Generaton_Child_Form() {

	}

	@Then("^PG: Enter Matter$")
	public void pg_Enter_Matter() {

	}

	@Then("^PG: Generate Proforma$")
	public void pg_Generate_Proforma() {

	}

	@Then("^PG: Verify Home Page Text$")
	public void pg_Verify_Home_Page_Text() {

	}

}
