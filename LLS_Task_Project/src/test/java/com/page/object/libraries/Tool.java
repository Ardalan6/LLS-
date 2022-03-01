package com.page.object.libraries;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tool extends Base {
	final static Logger logger = Logger.getLogger(Tool.class);

	public void clickButton(By by) {
		try {
			WebElement element = driver.findElement(by);
			element.click();
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);
		}
	}
	
	public void enterText(By by, String inputText) {
		try {
			WebElement element = driver.findElement(by);

			element.clear(); //
			element.sendKeys(inputText);

		} catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);
		}
	}
	
	public void moveToElement(By by) {
		try {
			WebElement element = driver.findElement(by);
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			customWait(0.5);
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);
		}
	}
	
	public WebElement dynamicWaitForPresenceOfElement(By by) {
		WebElement element = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, defaultWaitTimeInSecs);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(by));

		} catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);
		}
		return element;
	}
	
	public void customWait(double inSeconds) {
		try {
			Thread.sleep((long) (inSeconds * 1000));
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);
		}
	}
}
