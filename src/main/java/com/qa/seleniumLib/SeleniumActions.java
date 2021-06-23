package com.qa.seleniumLib;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.qa.base.BaseTest;
import com.qa.javaLib.JavaUtil;

public class SeleniumActions extends BaseTest {

	JavascriptExecutor jse;

	SeleniumWait sWait;

	public SeleniumActions() {
		jse = (JavascriptExecutor) driver;
		sWait = new SeleniumWait();
	}

	// Scroll To The Element
	public void scrollToElement(WebElement element) {
		sWait.eWaitForElementToBeClickable(element);
		jse.executeScript("arguments[0].scrollIntoView()", element);
	}

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
		//sWait.eWaitForVisible(txtBx);
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

	// This Function will take screenshot and return screenshot path
	public static String takeScreenshotPath(WebDriver driver, String scenarioName) {
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
		// JenkinsScreenshot Path :
		// String jenkinsScreenshotPath = TestData.getScreenshotPath() + scenarioName +
		// "_" + JavaUtil.timestamp() + ".png";

		return localScreenshotPath;
	}

}
