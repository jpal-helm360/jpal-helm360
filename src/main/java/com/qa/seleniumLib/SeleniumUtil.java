package com.qa.seleniumLib;

import java.io.File;
import java.time.Duration;
import java.util.function.Function;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import com.qa.base.BaseTest;
import com.qa.javaLib.JavaUtil;

public class SeleniumUtil extends BaseTest {

	public static JavascriptExecutor jse;

	public static final int implicitWait = 5;

	public static final int explicitWait = 15;

	public static final int fluentWait = 15;

	public static final int pageLoadWait = 10;

	public static final int waitForPageTitle = 5;

	// Hard Wait
	public static final int hardWait_general = 5;

	// Creating java Script object and casting into driver:
	public SeleniumUtil() {
		jse = (JavascriptExecutor) driver;
	}

	// Scroll To The Element
	public void scrollToElement(WebElement element) {
		jse.executeScript("arguments[0].scrollIntoView()", element);
	}

	// To JS Click on Element:
	public void jsClick(WebElement element) {
		fluentWait(element);
		jse.executeScript("arguments[0].click();", element);
	}

	public void doubleClick(WebElement element) {
		Actions act = new Actions(driver);
		// WebElement ele=driver.findElement(By.xpath("//span[text()='Work
		// Currency']"));
		// ((JavascriptExecutor)driver).executeScript("arguments[0].dblclick();",
		// element);
		// jse.executeScript("arguments[0].dblclick();", element);
		/*
		 * ((JavascriptExecutor)
		 * driver).executeScript("var evt = document.createEvent('MouseEvents');"+
		 * "evt.initMouseEvent('dblclick',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
		 * + "arguments[0].dispatchEvent(evt);", element);
		 */

		act.doubleClick(element).build().perform();
	}

	// To Click on Element:
	public void doClick(WebElement element) {
		fluentWait(element);
		element.click();
	}

	public void submit(WebElement element) {
		fluentWait(element);
		element.submit();
	}

	// To Check Element is displayed:
	public boolean isDisplayed(WebElement element) {
		fluentWait(element);
		return element.isDisplayed();
	}

	// Fluent Wait:
	public WebElement fluentWait(WebElement element) {
		FluentWait<WebDriver> fluent = new FluentWait<WebDriver>(driver);
		fluent.withTimeout(Duration.ofSeconds(fluentWait));
		fluent.pollingEvery(Duration.ofMillis(100));
		fluent.ignoring(NoSuchElementException.class);
		fluent.ignoring(TimeoutException.class);
		WebElement wb = fluent.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				if (element.isDisplayed()) {
					return element;
				} else {
					return null;
				}
			}
		});
		return wb;
	}

	// To Wait For Page Load:
	public void eWaitForPageLoad() {
		FluentWait<WebDriver> fluent = new FluentWait<WebDriver>(driver);
		fluent.withTimeout(Duration.ofSeconds(pageLoadWait));
		fluent.pollingEvery(Duration.ofMillis(100));
		fluent.ignoring(NoSuchElementException.class);
		fluent.ignoring(TimeoutException.class);
		fluent.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				// System.out.println( "Current Window State :" +
				// String.valueOf(jse.executeScript("return document.readyState")));
				boolean isPageLoad = String.valueOf(jse.executeScript("return document.readyState")).equals("complete");
				return isPageLoad;
			}
		});
	}

	// To Wait For JQuery Load:
	public void eWaitForJQueryLoad() {
		FluentWait<WebDriver> fluent = new FluentWait<WebDriver>(driver);
		fluent.withTimeout(Duration.ofSeconds(pageLoadWait));
		fluent.pollingEvery(Duration.ofMillis(100));
		fluent.ignoring(NoSuchElementException.class);
		fluent.ignoring(TimeoutException.class);
		fluent.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				boolean isJQueryLoad = (boolean) jse.executeScript("return jQuery.active==0");
				return isJQueryLoad;
			}
		});
	}

	// Enter Data into TextBox
	public void enterData(WebElement txtBx, String input) {
		fluentWait(txtBx);
		if (txtBx.getAttribute("value") != null) {
			txtBx.clear();
			txtBx.sendKeys(input);
		} else {
			txtBx.sendKeys(input);
		}
	}

	// SendKeys through keyBoard Buttons
	public void enterThroughKeys(Keys key) {
		Actions act = new Actions(driver);
		act.sendKeys(key).build().perform();
	}

	public String getText(WebElement element) {
		fluentWait(element);
		return element.getText();
	}

	public void iSleep() {
		try {
			Thread.sleep(hardWait_general * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// This Function will take screenshot and return screenshot path
	public static String takeScreenshotPath(WebDriver driver, String scenarioName) {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		// LocalScreenshot Path :
		String localScreenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + scenarioName + "_"
				+ JavaUtil.timestamp() + ".png";
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