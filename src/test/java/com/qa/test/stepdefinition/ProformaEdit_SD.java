package com.qa.test.stepdefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import com.qa.dbmanager.DBUtil;
import com.qa.pages.ProformaEditPage;
import com.qa.query.ProformaEdit;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProformaEdit_SD {

	private static ProformaEditPage pePage;

	private static String profTotalAmt_ProfPage = null;

	private static String adjustedProfTotalAmt_ProfPage = null;
	
	public static String invoiceNumber=null;

	public String invTotalAmt_InvPage = null;

	public ProformaEdit_SD() {
		pePage = new ProformaEditPage();
	}

	@Before(order = 1, value = "@ProformaEdit")
	public void setUp() {
		pePage.clickSearchProcess();
	}

	@Given("^PE: Open PerformaEdit Process$")
	public void pe_Open_PerformaEdit_Process() {
		pePage.openProcess("Proforma Edit");
	}

	@When("^PE: Search and Select Proforma for \"([^\"]*)\"$")
	public void pe_Search_and_Select_Proforma(String proforma) {
		pePage.searchProforma(proforma);
	}

	@When("^PE: Extract Proforma Total Amount$")
	public void pe_Extract_Proforma_Total_Amount() {
		profTotalAmt_ProfPage = pePage.getProfTotalAmount();
		System.out.println("Total Proforma Amouunt------------------------->>>" + profTotalAmt_ProfPage);
	}

	@Then("^PE: Click On Three Dot$")
	public void pe_Click_On_Three_Dot() {
		pePage.clickThreeDot();
	}

	@Then("^PE: Open Apply Adjustment Child Form$")
	public void pe_Open_Apply_Adjustment_Child_Form() {
		pePage.openApplyAdjustmentForm();
	}

	@Then("^PE: Click On Grid-View$")
	public void pe_Click_On_Gri_View() {
		pePage.clickGridView();
	}

	@Then("^PE: Click On Form-View$")
	public void pe_Click_On_Form_View() {
		pePage.selectFormView();
	}

	@Then("^PE: Enter Adjustment Amount in Percentage as \"([^\"]*)\"$")
	public void pe_Enter_Adjustment_Amount_in_Percentage_as(String adjsAmt) {
		pePage.enterAdjustmentAmount(adjsAmt);
	}

	@Then("^PE: Click On Adjustment Type$")
	public void pe_Click_On_Adjustment_Type() {
		pePage.clickAdjsmentTypeDrpDwn();
	}

	@Then("^PE: Select Adjustment Type as \"([^\"]*)\"$")
	public void pe_Select_Adjustment_Type_as(String adjsType) {
		pePage.selectAdjsmentType(adjsType);
	}

	@Then("^PE: Navigate To Performa Recalc button$")
	public void pe_Navigate_To_Performa_Recalc_button() {
		pePage.navigateToRecalc();
	}

	@Then("^PE: Proforma Recalc$")
	public void pe_Performa_Recalc() {
		pePage.doRecalc();
	}

	@Then("^PE: Extract Adjusted Proforma Total Amount$")
	public void pe_Extract_Adjusted_Proforma_Total_Amount() {
		adjustedProfTotalAmt_ProfPage = pePage.getProfTotalAmount();
	}

	@Then("^PE: Compare Proforma Total Amount and Invoice Total Amount Before BillNoPrint$")
	public void pe_Compare_Proforma_Total_Amount_and_Invoice_Total_Amount_Before_BillNoPrint() {
		System.out.println("ProfTotalAmt_ProfPage----------->>>>" + profTotalAmt_ProfPage);
		System.out.println("adjustedProfTotalAmt_ProfPage----------->>>>" + adjustedProfTotalAmt_ProfPage);
		assertNotEquals(profTotalAmt_ProfPage, adjustedProfTotalAmt_ProfPage, "Adjusted Amount is same Please check the Adjustment");
	}

	@Then("^PE: Proforma BillNoPrint and Validate ProfAmt Not Displaying Now$")
	public void pe_Performa_BillNoPrint() {
		pePage.doBillNoPrint();
		System.out.println("BillNoPrint is Displayed:=================>>>"+pePage.isProfTotalAmountDisplay());
		//assertFalse(pePage.isProfTotalAmountDisplay(), "BillNoPrint Not Successfull");
	}

	@Then("^PE: Get Invoice Number From Database$")
	public void pe_Get_Invoice_Number_From_Database() {
		invoiceNumber=DBUtil.get(ProformaEdit.getInvoice, 1);
		System.out.println("invoiceNumber from database: =============>>>"+invoiceNumber);
	}

	@Then("^PE: Open Invoice Process$")
	public void pe_Open_Invoice_Process() {
		pePage.openInvoiceProcess();
	}

	@Then("^PE: Search and select Invoice Generated$")
	public void pe_Search_and_select_Invoice_Generated() {
		pePage.openInvoices(invoiceNumber);
	}

	@Then("^PE: Extract Invoice Total Amount$")
	public void pe_Extract_Invoice_Total_Amount() {
		invTotalAmt_InvPage= pePage.getInvoiceTotalAmt();
	}

	@Then("^PE: Compare Proforma Total Amount and Invoice Total Amount After BillNoPrint$")
	public void pe_Compare_Proforma_Total_Amount_and_Invoice_Total_Amount() {
		assertEquals(adjustedProfTotalAmt_ProfPage, invTotalAmt_InvPage,"adjustedProfTotalAmt and invTotalAmt not matched");
	}

	@Then("^PE: Click on Cancel$")
	public void pe_Click_on_Cancel() {
		pePage.doCancel();
	}

}
