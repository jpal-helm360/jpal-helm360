package com.qa.testlibrary;

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

import com.qa.constant.SelWaitConst;

public class SeleniumWait extends DriverFactory {

	JavascriptExecutor jse;

	public SeleniumWait() {
		jse = (JavascriptExecutor) driver;
	}

	// ****************************************************************************
	// Explicit wait on element visibility
	// ****************************************************************************
	public WebElement eWaitForVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, SelWaitConst.explicitWait);
		WebElement wb = wait.until(ExpectedConditions.visibilityOf(element));
		return wb;
	}

	// ****************************************************************************
	// Explicit wait on element visibility
	// ****************************************************************************
	public void eWaitForElementsVisible(List<WebElement> elements) {
		WebDriverWait wait = new WebDriverWait(driver, SelWaitConst.explicitWait);
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));

	}

	// ****************************************************************************
	// Explicit wait on element is Click able
	// ****************************************************************************
	public void eWaitForElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, SelWaitConst.explicitWait);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// ****************************************************************************
	//
	// ****************************************************************************

	public void iSleep(int hardWait) {
		try {
			Thread.sleep(hardWait * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// ****************************************************************************
	// Fluent Wait:
	// ****************************************************************************
	public WebElement fluentWait(WebElement element) {
		FluentWait<WebDriver> fluent = new FluentWait<WebDriver>(driver);
		fluent.withTimeout(Duration.ofSeconds(SelWaitConst.fluentWait));
		fluent.pollingEvery(Duration.ofMillis(100));
		fluent.ignoring(NoSuchElementException.class);
		fluent.ignoring(TimeoutException.class);
		WebElement wb = fluent.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				if (element.isEnabled()) {
					return element;
				} else {
					return null;
				}
			}
		});
		return wb;
	}

	// ****************************************************************************
	//
	// ****************************************************************************
	public void eWaitForPageLoad() {
		FluentWait<WebDriver> fluent = new FluentWait<WebDriver>(driver);
		fluent.withTimeout(Duration.ofSeconds(SelWaitConst.pageLoadWait));
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

}