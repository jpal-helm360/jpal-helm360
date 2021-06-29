package com.qa.testlibrary;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.constant.WaitingTime;

public class SeleniumWait extends DriverFactory {

	// WebElement element=null;

	// Dynamic Wait

	JavascriptExecutor jse;

	WebDriverWait wait;

	public SeleniumWait() {
		jse = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, WaitingTime.explicitWait);
	}

	// ****************************************************************************
	// fluentWait on given Element :
	// ****************************************************************************
	public WebElement fluentWait(WebElement element) {
		FluentWait<WebDriver> fluent = new FluentWait<WebDriver>(driver);
		fluent.withTimeout(Duration.ofSeconds(WaitingTime.fluentWait));
		fluent.pollingEvery(Duration.ofMillis(100));
		fluent.ignoring(NoSuchElementException.class);
		fluent.ignoring(TimeoutException.class);
		WebElement wb = fluent.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				if (element.isDisplayed() && element.isEnabled()) {
					return element;
				} else {
					return null;
				}
			}
		});
		return wb;
	}

	// ****************************************************************************
	// To Wait for JS load :
	// ****************************************************************************
	public void eWaitForJSLoad() {
		FluentWait<WebDriver> fluent = new FluentWait<WebDriver>(driver);
		fluent.withTimeout(Duration.ofSeconds(WaitingTime.pageLoadWait));
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
	// To Wait for JQuery load :
	// ****************************************************************************
	public void eWaitForJQueryLoad() {
		FluentWait<WebDriver> fluent = new FluentWait<WebDriver>(driver);
		fluent.withTimeout(Duration.ofSeconds(WaitingTime.pageLoadWait));
		fluent.pollingEvery(Duration.ofMillis(100));
		fluent.ignoring(NoSuchElementException.class);
		fluent.ignoring(TimeoutException.class);
		fluent.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				boolean isJsLoaded = ((int) jse.executeScript("return jQuery.active") == 0);
				return isJsLoaded;
			}
		});
	}

	// ****************************************************************************
	// To Wait for JS and JQyery load :
	// ****************************************************************************
	public boolean waitForPageLoad() {
		// wait for jQuery to load
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((int) jse.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					// no jQuery present
					return true;
				}
			}
		};

		// wait for JavaScript to load
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return (jse).executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return wait.until(jQueryLoad) && wait.until(jsLoad);
	}

	// ****************************************************************************
	// Boolean true when elements is not visible anymore :
	// ****************************************************************************
	public void eWaitForTextToBeChanged(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	// ****************************************************************************
	// Explicit wait on element visibility
	// ****************************************************************************
	public WebElement eWaitForVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, WaitingTime.explicitWait);
		WebElement wb = wait.until(ExpectedConditions.visibilityOf(element));
		return wb;
	}

	// ****************************************************************************
	// Explicit wait on elements visibility
	// ****************************************************************************
	public void eWaitForElementsVisible(List<WebElement> elements) {
		WebDriverWait wait = new WebDriverWait(driver, WaitingTime.explicitWait);
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));

	}

	// ****************************************************************************
	// Explicit wait on element to be Click able
	// ****************************************************************************
	public void eWaitForElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, WaitingTime.explicitWait);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// ****************************************************************************
	// Explicit wait on element to be invisible:
	// ****************************************************************************
	public void eWaitForInvisibilityOf(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, WaitingTime.explicitWait);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	// ****************************************************************************
	// Explicit wait on element Text to be present:
	// ****************************************************************************
	public void eWaitForTextToBePresentInElement(WebElement element, String text) {
		WebDriverWait wait = new WebDriverWait(driver, WaitingTime.explicitWait);
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	// ****************************************************************************
	// Hard Wait :
	// ****************************************************************************
	public void iSleep(int hardWait) {
		try {
			Thread.sleep(hardWait * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}