package com.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.BaseTest;
import com.qa.seleniumLib.SeleniumUtil;

public class CostEntryPage extends BaseTest {
	
	SeleniumUtil sUtil;

	@FindBy(xpath = "//div[@class='search-button']")
	private WebElement searchPocessBtn;

	@FindBy(xpath = "//input[@id='mat-input-1']")
	private WebElement processNameTxtBx;

	@FindBy(xpath = "//button[@id='add-title-button']")
	private WebElement addBtn;

	@FindBy(xpath = "//div[@class='e3e-dialog__title-bar-label']")
	private WebElement processLabel;

	@FindBy(xpath = "//h3[text()='Time Entry']")
	private WebElement timeEntryHeader;

	@FindBy(xpath = "//span[text()='Timekeeper']//ancestor::e3e-bound-input//input")
	private WebElement timekeeperTxtBx;
	
	@FindBy(xpath = "//span[text()='Matter']//ancestor::e3e-bound-input//input")
	private WebElement matterTxtBx;
	
	@FindBy(xpath = "//span[text()='Cost Type']//ancestor::e3e-bound-input//input")
	private WebElement costTypeTxtBx;
	
	@FindBy(xpath = "//span[text()='Quantity']//ancestor::e3e-bound-input//input")
	private WebElement quantityTxtBx;
	
	@FindBy(xpath = "//span[text()='Work Currency']//ancestor::e3e-bound-input//input")
	private WebElement workCurrecyTxtBx;
	                   
	@FindBy(xpath = "//span[text()='Work Rate']//ancestor::e3e-bound-input//input")
	private WebElement workRateTxtBX;
	
	@FindBy(xpath = "//span[text()='Narrative']//ancestor::e3e-bound-input//div[@class='ql-editor ql-blank']")
	private WebElement narrativeTxtBx;
	
	@FindBy(xpath = "//span[text()=' Post All ']")
	private WebElement postAllBtn;
	
	@FindBy(xpath = "//span[text()='Home Page']")
	private WebElement homeText;

	public CostEntryPage() {
		PageFactory.initElements(driver, this);
		sUtil = new SeleniumUtil();
	}

	public void clickSearchProcess() {
		sUtil.doClick(searchPocessBtn);
		sUtil.iSleep();
	}

	public void openProcess(String processName) {
		sUtil.enterData(processNameTxtBx, processName);
		sUtil.iSleep();
		sUtil.enterThroughKeys(Keys.ENTER);
	}

	public void clickAdd() {
		//sUtil.doClick(addBtn);
		sUtil.jsClick(addBtn);
	}

	public String getHeader() {
		return sUtil.getText(timeEntryHeader);
	}

	public void enterTkpNumber(String tkp) {
		sUtil.enterData(timekeeperTxtBx, tkp);
		sUtil.enterThroughKeys(Keys.ENTER);
	}
	
	public void enterMatter(String maater) {
		sUtil.enterData(matterTxtBx, maater);
		sUtil.enterThroughKeys(Keys.ENTER);
	}
	
	public void enterCostType(String costType) {
		sUtil.enterData(costTypeTxtBx, costType);
		sUtil.enterThroughKeys(Keys.ENTER);
	}
	
	public void enterQuantity(String quantity) {
		sUtil.enterData(quantityTxtBx, quantity);
		sUtil.enterThroughKeys(Keys.ENTER);
	}
	
	public void enterWorkCurrency(String wkCurrency) {
		sUtil.scrollToElement(workCurrecyTxtBx);
		sUtil.enterData(workCurrecyTxtBx, wkCurrency);
		sUtil.enterThroughKeys(Keys.ENTER);
	}
	
	public void enterWorkRate(String wkRate) {
		sUtil.enterData(workRateTxtBX, wkRate);
		sUtil.enterThroughKeys(Keys.ENTER);
	}
	
	public void enterNarrative(String narrative) {
		sUtil.scrollToElement(narrativeTxtBx);
		sUtil.enterData(narrativeTxtBx, narrative);
		sUtil.enterThroughKeys(Keys.ENTER);
	}

	public void ClickPostAll() {
		sUtil.doClick(postAllBtn);
	}
	
	public String getText() {
		return sUtil.getText(homeText);
	}
	

}
