package com.qa.seleniumLib;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.qa.base.BaseTest;

public class SeleniumWait extends BaseTest {

	// WebElement element=null;

	// Dynamic Wait

	JavascriptExecutor jse;

	public static final int implicitWait = 5;

	public static final int explicitWait = 15;

	public static final int fluentWait = 15;

	public static final int pageLoadWait = 10;

	public static final int waitForPageTitle = 5;

	// Hard Wait
	public static final int hardWait_general = 5;

	public SeleniumWait() {
		jse = (JavascriptExecutor) driver;
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

	public void eWaitForPageLoad() {
		FluentWait<WebDriver> fluent = new FluentWait<WebDriver>(driver);
		fluent.withTimeout(Duration.ofSeconds(pageLoadWait));
		fluent.pollingEvery(Duration.ofMillis(100));
		fluent.ignoring(NoSuchElementException.class);
		fluent.ignoring(TimeoutException.class);
		fluent.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				boolean isJsLoaded = String.valueOf(jse.executeScript("return document.readyState")).equals("complete");
				return isJsLoaded;
			}
		});
	}

	// ****************************************************************************
	// Explicit wait on element visibility
	// ****************************************************************************
	public WebElement eWaitForVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, explicitWait);
		WebElement wb = wait.until(ExpectedConditions.visibilityOf(element));
		return wb;
	}

	// ****************************************************************
	// Explicit wait on element visibility
	// ****************************************************************
	public void eWaitForElementsVisible(List<WebElement> elements) {
		WebDriverWait wait = new WebDriverWait(driver, explicitWait);
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));

	}

	// ****************************************************************************
	// Explicit wait on element is Click able
	// ****************************************************************************
	public void eWaitForElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, explicitWait);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void iSleep(int hardWait) {
		try {
			Thread.sleep(hardWait * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}