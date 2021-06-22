/*package com.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.BaseTest;
import com.qa.seleniumLib.SeleniumUtil;

public class CostEntryPage extends BaseTest {

	SeleniumUtil sUtil;

	@FindBy(xpath = "//span[text()='Cost Type']//ancestor::e3e-bound-input//input")
	private WebElement costTypeTxtBx;

	@FindBy(xpath = "//span[text()='Matter']//ancestor::e3e-bound-input//input")
	private WebElement matterTxtBx;
	
	@FindBy(xpath = "//span[text()='Timekeeper']//ancestor::e3e-bound-input//input")
	private WebElement timekeeperTxtBx;

	@FindBy(xpath = "//span[text()='Quantity']//ancestor::e3e-bound-input//input")
	private WebElement quantityTxtBx;

	@FindBy(xpath = "//span[text()='Work Currency']//ancestor::e3e-bound-input//input")
	private WebElement currencyTxtBx;

	@FindBy(xpath = "//span[text()='Work Rate']//ancestor::e3e-bound-input//input")
	private WebElement workRateTxtBx;
	
	@FindBy(xpath = "//span[text()='Narrative']//ancestor::e3e-bound-input//input")
	private WebElement narrativeTxtBx;

	@FindBy(xpath = "//span[text()=' Post All ']")
	private WebElement postAllBtn;

	public CostEntryPage() {
		PageFactory.initElements(driver, this);
		sUtil = new SeleniumUtil();
	}
	
	public void enterCostType(String costType) {
		sUtil.enterData(costTypeTxtBx, costType);
		sUtil.enterThroughKeys(Keys.ENTER);
	}
	
	public void enterMatter(String matter) {
		sUtil.enterData(matterTxtBx, matter);
		sUtil.enterThroughKeys(Keys.ENTER);
	}
	
	public void enterTimekeeper(String timekeeper) {
		sUtil.enterData(timekeeperTxtBx, timekeeper);
		sUtil.enterThroughKeys(Keys.ENTER);
	}
	
	public void enterQuantity(String quantity) {
		sUtil.enterData(quantityTxtBx, quantity);
		sUtil.enterThroughKeys(Keys.ENTER);
	}
	
	public void enterCurrency(String currency) {
		sUtil.enterData(currencyTxtBx, currency);
		sUtil.enterThroughKeys(Keys.ENTER);
	}
	
	public void enterWorkRate(String workRate) {
		sUtil.enterData(workRateTxtBx, workRate);
		sUtil.enterThroughKeys(Keys.ENTER);
	}
	
	public void eneterNarrative(String narrative) {
		sUtil.enterData(narrativeTxtBx, narrative);
		sUtil.enterThroughKeys(Keys.ENTER);
	}
	
	public void postAll() {
		sUtil.doClick(postAllBtn);
	}
	

}
*/