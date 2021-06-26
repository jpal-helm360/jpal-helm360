package com.qa.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testLib.DriverFactory;
import com.qa.testLib.SeleniumActions;
import com.qa.testLib.SeleniumWait;

public class ProformaEditPage extends DriverFactory {

	SeleniumActions sActions;

	@FindBy(xpath = "//div[@class='search-button']")
	private WebElement searchPocessBtn;

	@FindBy(xpath = "//input[@id='mat-input-1']")
	private WebElement processNameTxtBx;

	@FindBy(xpath = "//e3e-quickfind-content//input[starts-with(@id,'mat-input-')]")
	private WebElement searchProformaTxtBx;

	@FindBy(xpath = "//e3e-form-tabbed-view-menu//mat-icon[@role='img' and text()='more_vert']")
	private WebElement threeDotBtn;

	@FindBy(xpath = "//span[text()=' Apply Adjustment ']")
	private WebElement applyAdjsBtn;

	@FindBy(xpath = "//span[text()=' Apply Adjustment ']//following::button[text()=' Add ']")
	private WebElement applyAdjsAddBtn;

	@FindBy(xpath = "//e3e-form-view-selector//button[@type='button']")
	private WebElement gridViewDrpDwnBtn;

	@FindBy(xpath = "//e3e-form-view-selector//button[@type='button']//following::span[text()=' Form']")
	private WebElement formViewBtn;

	@FindBy(xpath = "//e3e-decimal-input//input")
	private WebElement adjPercentageAmtTxtBx;
	
	@FindBy(xpath = "//span[text()='Adjustment Type']//following::e3e-small-list-input//mat-icon[@role='img']")
	private WebElement adjsTypeDrpDwn;

	@FindBy(xpath = "//span[text()='Adjustment Type']//ancestor::e3e-bound-input//input")
	private WebElement adjsTypeTxtBx;

	@FindBy(xpath = "//e3e-toolbar-buttons//mat-icon[text()='chevron_left']")
	private WebElement toolbarBtn;

	@FindBy(xpath = "//button[@data-automation-id='Recalc_Charges']")
	private WebElement recalcBtn;

	@FindBy(xpath = "//button[@data-automation-id='Bill_NP']")
	private WebElement billNoPrintBtn;

	@FindBy(xpath = "//button[@data-automation-id='CANCEL']")
	private WebElement cancelBtn;

	@FindBy(xpath = "(//e3e-process-worklist//div[@col-id='TotAmt' and @role='gridcell'])[2]")
	private WebElement profTotalAmt;

	@FindBy(xpath = "//e3e-quickfind-content//input[starts-with(@id,'mat-input-')]")
	private WebElement searchInvIpTxtBx;

	@FindBy(xpath = "(//e3e-process-worklist//div[@col-id='IsPaid' and @role='gridcell'])[2]")
	private WebElement invTotalAmt;

	@FindBy(xpath = "//h5[text()='Invoice Detail']")
	private WebElement invoiceDetailBtn;
	
	@FindBy(xpath = "(//div[@role='gridcell' and @col-id='InvNumber'])[1]")
	private WebElement textbbb;

	@FindBy(xpath = "//span[text()='Home Page']")
	private WebElement homeText;

	public ProformaEditPage() {
		PageFactory.initElements(driver, this);
		sActions = new SeleniumActions();
	}

	public void clickSearchProcess() {
		// sUtil.doClick(searchPocessBtn);
		// sUtil.iSleep(SeleniumUtil.processBtnClick_Pre);
		// sUtil.iSleep();
	}

	public void openProcess(String processName) {
		sActions.enterData(processNameTxtBx, processName);
		// sUtil.iSleep(SeleniumUtil.enterProcessName_Post);
		// sUtil.iSleep();
		new SeleniumWait().iSleep(5);
		sActions.enterThroughKeys(Keys.ENTER);
	}

	public void searchProforma(String proforma) {
		new SeleniumWait().iSleep(3);
		sActions.enterData(searchProformaTxtBx, proforma);
		sActions.enterThroughKeys(Keys.ENTER);
	}

	public String getProfTotalAmount() {
		return sActions.getText(profTotalAmt);
	}

	public void clickThreeDot() {
		sActions.doClick(threeDotBtn);
	}

	public void openApplyAdjustmentForm() {
		sActions.doClick(applyAdjsBtn);
		sActions.navigateToSubMenu(applyAdjsAddBtn);
		sActions.doClick(applyAdjsAddBtn);
	}

	public void clickGridView() {
		sActions.jsClick(gridViewDrpDwnBtn);
	}

	public void selectFormView() {
		sActions.jsClick(formViewBtn);
	}

	public void enterAdjustmentAmount(String adjsAmt) {
		sActions.enterData(adjPercentageAmtTxtBx, adjsAmt);
		sActions.enterThroughKeys(Keys.ENTER);
	}

	public void clickAdjsmentTypeDrpDwn() {
		sActions.jsClick(adjsTypeDrpDwn);
	}
	
	public void selectAdjsmentType(String xpath) {
		//sActions.jsClick(sActions.getWebelement(xpath));
		//span[text()='Adjustment- Display on Bill']
		sActions.jsClick(sActions.getWebelement("//span[text()='", xpath, "']"));
	}

	public void navigateToRecalc() {
		for (int i = 0; i <= 3; i++) {
			System.out.println("navigateToRecalc:-------------------------->>>"+i);
			sActions.jsClick(toolbarBtn);
		}
	}

	public void doRecalc() {
		sActions.jsClick(recalcBtn);
	}

	public void doBillNoPrint() {
		sActions.jsClick(billNoPrintBtn);
		new SeleniumWait().iSleep(5);
	}

	public String getText() {
		return sActions.getText(homeText);
	}

	public void openInvoiceProcess() {
		sActions.jsClick(searchPocessBtn);
		openProcess("Invoices");
	}

	public void openInvoices(String invoiceNumber) {
		sActions.enterData(searchInvIpTxtBx, invoiceNumber);
		sActions.enterThroughKeys(Keys.ENTER);
		//sActions.jsClick(textbbb);
	}

	public String getInvoiceTotalAmt() {
		return sActions.getText(invTotalAmt);
	}

	public void doCancel() {
		sActions.doClick(cancelBtn);
	}

}