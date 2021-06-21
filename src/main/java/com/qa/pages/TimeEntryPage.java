package com.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.BaseTest;
import com.qa.seleniumLib.SeleniumUtil;

public class TimeEntryPage extends BaseTest {

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
	
	@FindBy(xpath = "//span[text()='Time Type']//ancestor::e3e-bound-input//input")
	private WebElement timeTypeTxtBx;
	
	@FindBy(xpath = "//span[text()='Hours']//ancestor::e3e-bound-input//input")
	private WebElement hoursTxtBX;
	
	@FindBy(xpath = "//span[text()='Narrative']//ancestor::e3e-bound-input//div[@class='ql-editor ql-blank']")
	private WebElement narrativeTxtBx;
	
	@FindBy(xpath = "//span[text()=' Post All ']")
	private WebElement postAllBtn;
	
	@FindBy(xpath = "//span[text()='Home Page']")
	private WebElement homeText;
	
	

	public TimeEntryPage() {
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
	
	public void enterTimeType(String timeType) {
		sUtil.enterData(timeTypeTxtBx, timeType);
		sUtil.enterThroughKeys(Keys.ENTER);
	}
	
	public void enterHours(String hours) {
		sUtil.enterData(hoursTxtBX, hours);
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
