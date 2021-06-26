package com.qa.testlibrary;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SeleniumActions extends DriverFactory {

	JavascriptExecutor jse;

	SeleniumWait sWait;

	public SeleniumActions() {
		jse = (JavascriptExecutor) driver;
		sWait = new SeleniumWait();
	}

	// ****************************************************************************
	// To JS Click on Element:
	// ****************************************************************************
	public void jsClick(WebElement element) {
		sWait.eWaitForElementToBeClickable(element);
		// sWait.fluentWait(element);
		// sWait.iSleep(5);
		jse.executeScript("arguments[0].click();", element);

	}

	// ****************************************************************************
	// To Click on Element:
	// ****************************************************************************

	public void doClick(WebElement element) {
		sWait.eWaitForElementToBeClickable(element);
		element.click();
	}

	// ****************************************************************************
	// Enter Data into TextBox:
	// ****************************************************************************
	public void enterData(WebElement txtBx, String input) {
		sWait.iSleep(3);
		// sWait.eWaitForVisible(txtBx);
		// sWait.eWaitForElementToBeClickable(txtBx);
		// sWait.fluentWait(txtBx);
		// sWait.eWaitForPageLoad();
		if (txtBx.getAttribute("value") != null) {
			txtBx.clear();
			txtBx.sendKeys(input);
		} else {
			txtBx.sendKeys(input);
		}
	}

	// ****************************************************************************
	// SendKeys through keyBoard Buttons:
	// ****************************************************************************

	public void enterThroughKeys(Keys key) {
		Actions act = new Actions(driver);
		act.sendKeys(key).build().perform();
	}

	// ****************************************************************************
	// Scroll To The Element:
	// ****************************************************************************
	public void scrollToElement(WebElement element) {
		// sWait.eWaitForElementToBeClickable(element);
		sWait.eWaitForVisible(element);
		jse.executeScript("arguments[0].scrollIntoView()", element);
	}

	// ****************************************************************************
	// To Check Element is displayed:
	// ****************************************************************************
	public boolean isDisplayed(WebElement element) {
		sWait.fluentWait(element);
		return element.isDisplayed();
	}

	// ****************************************************************************
	// To Check Element is displayed:
	// ****************************************************************************
	public String getText(WebElement element) {
		sWait.fluentWait(element);
		return element.getText();
	}

	// ****************************************************************************
	//
	// ****************************************************************************
	public String getAlertText() {
		return driver.switchTo().alert().getText();
	}

	// ****************************************************************************
	//
	// ****************************************************************************
	public void navigateToSubMenu(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}

	// ****************************************************************************
	// Clear Data into TextBox:
	// ****************************************************************************
	public void clearData(WebElement txtBx) {
		sWait.iSleep(3);
		txtBx.clear();
		enterThroughKeys(Keys.ENTER);
	}

	// ****************************************************************************
	//
	// ****************************************************************************
	public void clickProcessSearch(WebElement searchProcessBtn) {
		sWait.iSleep(5);
		doClick(searchProcessBtn);
		sWait.iSleep(2);
	}

	// ****************************************************************************
	//
	// ****************************************************************************
	public void openProcess(WebElement processNameTxtBx, String processName) {
		enterData(processNameTxtBx, processName);
		sWait.iSleep(5);
		enterThroughKeys(Keys.ENTER);
	}

	// ****************************************************************************
	// This Function will take screenshot and return screenshot path:
	// ****************************************************************************
	public static String getScreenshotPath(WebDriver driver, String scenarioName) {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		// LocalScreenshot Path :
		String localScreenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + scenarioName + "_"
				+ JavaUtil.currentTimestamp() + ".png";
		try {
			FileUtils.copyFile(source, new File(localScreenshotPath));
		} catch (Exception e) {
			e.getMessage();
		}
		// Remote Screenshot Path : F
		// String remoteScreenshotPath = TestData.getScreenshotPath() + scenarioName +
		// "_" + JavaUtil.timestamp() + ".png";

		return localScreenshotPath;
	}

	// ****************************************************************************
	// This Function Return The WebElement:
	// ****************************************************************************
	public WebElement getWebelement(String firstXpath, String dynamicXpath, String lastXpath) {
		return driver.findElement(By.xpath(firstXpath + dynamicXpath + lastXpath));
	}

}
