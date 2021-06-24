package com.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testLib.DriverFactory;
import com.qa.testLib.SeleniumActions;
import com.qa.testLib.SeleniumWait;

public class TimeEntryPage extends DriverFactory {

	SeleniumActions sActions;

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
		sActions = new SeleniumActions();
	}

	public void clickSearchProcess() {
		//sUtil.doClick(searchPocessBtn);
		//sUtil.iSleep(SeleniumUtil.processBtnClick_Pre);
		//sUtil.iSleep();
	}

	public void openProcess(String processName) {
		sActions.enterData(processNameTxtBx, processName);
		//sUtil.iSleep(SeleniumUtil.enterProcessName_Post);
		//sUtil.iSleep();
		new SeleniumWait().iSleep(5);
		sActions.enterThroughKeys(Keys.ENTER);
	}

	public void clickAdd() {
		//sUtil.doClick(addBtn);
		sActions.jsClick(addBtn);
	}

	public String getHeader() {
		return sActions.getText(timeEntryHeader);
	}

	public void enterTkpNumber(String tkp) {
		sActions.enterData(timekeeperTxtBx, tkp);
		sActions.enterThroughKeys(Keys.ENTER);
	}
	
	public void enterMatter(String maater) {
		sActions.enterData(matterTxtBx, maater);
		sActions.enterThroughKeys(Keys.ENTER);
	}
	
	public void enterTimeType(String timeType) {
		sActions.enterData(timeTypeTxtBx, timeType);
		sActions.enterThroughKeys(Keys.ENTER);
	}
	
	public void enterHours(String hours) {
		sActions.enterData(hoursTxtBX, hours);
		sActions.enterThroughKeys(Keys.ENTER);
	}
	
	public void enterNarrative(String narrative) {
		sActions.scrollToElement(narrativeTxtBx);
		sActions.enterData(narrativeTxtBx, narrative);
		sActions.enterThroughKeys(Keys.ENTER);
	}

	public void ClickPostAll() {
		sActions.doClick(postAllBtn);
	}
	
	public String getText() {
		return sActions.getText(homeText);
	}
	
}
