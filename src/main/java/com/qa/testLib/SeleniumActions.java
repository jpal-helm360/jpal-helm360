package com.qa.testLib;

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

	// Scroll To The Element
	public void scrollToElement(WebElement element) {
		// sWait.eWaitForElementToBeClickable(element);
		sWait.eWaitForVisible(element);
		jse.executeScript("arguments[0].scrollIntoView()", element);
	}

	/*
	 * // Scroll To The Bottom of Page public void scrollToEndOfPage(WebElement
	 * element) { // sWait.eWaitForElementToBeClickable(element);
	 * sWait.eWaitForVisible(element);
	 * jse.executeScript("arguments[0].scrollIntoView()", element); }
	 */

	// To JS Click on Element:
	public void jsClick(WebElement element) {
		sWait.eWaitForElementToBeClickable(element);
		jse.executeScript("arguments[0].click();", element);

	}

	// To Click on Element:
	public void doClick(WebElement element) {
		sWait.eWaitForElementToBeClickable(element);
		element.click();
	}

	// To Check Element is displayed:
	public boolean isDisplayed(WebElement element) {
		sWait.fluentWait(element);
		return element.isDisplayed();
	}

	// Enter Data into TextBox
	public void enterData(WebElement txtBx, String input) {
		sWait.iSleep(3);
		// sWait.eWaitForVisible(txtBx);
		if (txtBx.getAttribute("value") != null) {
			txtBx.clear();
			txtBx.sendKeys(input);
		} else {
			txtBx.sendKeys(input);
		}
	}

	// sendKeys through keyBoard Buttons

	public void enterThroughKeys(Keys key) {
		Actions act = new Actions(driver);
		act.sendKeys(key).build().perform();
	}

	public String getText(WebElement element) {
		sWait.fluentWait(element);
		return element.getText();
	}

	public String getAlertText() {
		return driver.switchTo().alert().getText();
	}

	public void navigateToSubMenu(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}

	// This Function will take screenshot and return screenshot path
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

	public WebElement getWebelement(String firstXpath,String dynamicXpath,String lastXpath) {	
		return driver.findElement(By.xpath(firstXpath+dynamicXpath+lastXpath));
	}

}
