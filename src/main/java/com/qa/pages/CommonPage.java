package com.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.BaseTest;
import com.qa.seleniumLib.SeleniumUtil;

public class CommonPage extends BaseTest {

	SeleniumUtil sUtil;

	@FindBy(xpath = "//div[@class='search-button']")
	private WebElement searchPocessBtn;

	@FindBy(xpath = "//input[@id='mat-input-1']")
	private WebElement processNameTxtBx;

	@FindBy(xpath = "//button[@id='add-title-button']")
	private WebElement addBtn;

	@FindBy(xpath = "//span[text()='Home Page']")
	private WebElement homeText;

	public CommonPage() {
		PageFactory.initElements(driver, this);
		sUtil = new SeleniumUtil();
	}

	public void clickSearchProcess() {
		sUtil.iSleep();
		sUtil.doClick(searchPocessBtn);
	}

	public void openProcess(String processName) {
		sUtil.enterData(processNameTxtBx, processName);
		sUtil.iSleep();
		sUtil.enterThroughKeys(Keys.ENTER);
	}

	public void clickAdd() {
		// sUtil.doClick(addBtn);
		sUtil.jsClick(addBtn);
	}

	public String getText() {
		return sUtil.getText(homeText);
	}

}
