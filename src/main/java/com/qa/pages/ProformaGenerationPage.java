package com.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.testlibrary.DriverFactory;
import com.qa.testlibrary.SeleniumActions;

public class ProformaGenerationPage extends DriverFactory {

	SeleniumActions sActions;

	@FindBy(xpath = "//div[@class='search-button']")
	private WebElement searchProcessBtn;

	@FindBy(xpath = "//input[@id='mat-input-1']")
	private WebElement processNameTxtBx;

	@FindBy(xpath = "//button[@id='add-title-button']")
	private WebElement addBtn;

	@FindBy(xpath = "//e3e-string-input//input")
	private WebElement descriptionTxtBx;

	@FindBy(xpath = "//span[text()='Reset Dates Using']//ancestor::e3e-bound-input//input")
	private WebElement restDatesUsingTxtBx;

	@FindBy(xpath = "//span[text()='Matter']//ancestor::e3e-bound-input//input")
	private WebElement matterTxtBx;

	@FindBy(xpath = "//span[text()='Include Entries on Other Proformas']//ancestor::e3e-bound-input//label[@class='mat-checkbox-layout']")
	private WebElement includesEntriesChkBx;
	
	@FindBy(xpath = "//e3e-form-tabbed-view-menu//mat-icon[@role='img' and text()='more_vert']")
	private WebElement threeDotBtn;

	@FindBy(xpath = "//span[text()=' Proforma Generation ']")
	private WebElement profGenBtn;

	@FindBy(xpath = "//span[text()=' Proforma Generation ']//following::button[text()=' Add ']")
	private WebElement profGenAddBtn;
	

	@FindBy(xpath = "//span[text()='Hours']//ancestor::e3e-bound-input//input")
	private WebElement hoursTxtBX;

	@FindBy(xpath = "//span[text()='Narrative']//ancestor::e3e-bound-input//div[@class='ql-editor ql-blank']")
	private WebElement narrativeTxtBx;

	@FindBy(xpath = "//span[text()=' Generate ']")
	private WebElement generateBtn;

	@FindBy(xpath = "//span[text()='Home Page']")
	private WebElement homePageText;

	public ProformaGenerationPage() {
		PageFactory.initElements(driver, this);
		sActions = new SeleniumActions();
	}

	public void openProcess(String processName) {
		sActions.openProcess(processNameTxtBx, processName);
	}

	public void clickAdd() {
		sActions.jsClick(addBtn);
	}

	public void enterDescription(String description) {
		sActions.enterData(descriptionTxtBx, description);
		sActions.enterThroughKeys(Keys.ENTER);
	}

	public void clearResetDatesUsing() {
		sActions.clearData(restDatesUsingTxtBx);
	}

	public void clickThreeDot() {
		sActions.doClick(threeDotBtn);
	}

	public void openProformaGeneration() {
		sActions.doClick(profGenBtn);
		sActions.navigateToSubMenu(profGenAddBtn);
		sActions.doClick(profGenAddBtn);
	}

	public void enterMatter(String narrative) {
		sActions.enterData(matterTxtBx, narrative);
		sActions.enterThroughKeys(Keys.ENTER);
	}

	public void doGenerate() {
		sActions.doClick(generateBtn);
	}

	public String getHomePageText() {
		return sActions.getText(homePageText);
	}

}
