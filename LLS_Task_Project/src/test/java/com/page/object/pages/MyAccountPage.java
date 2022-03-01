package com.page.object.pages;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.page.object.libraries.Base;

public class MyAccountPage extends Base{
	final static Logger logger = Logger.getLogger(MyAccountPage.class);
	
	// Locators for 'MyAccountPage'
	By accountUserName = By.cssSelector(".account");
	By tShirtBtn = By.xpath("(//a[@title='T-shirts'])[2]");
	
	
	public MyAccountPage() {
		String websiteTitle = driver.getTitle();
		logger.info("Website title is: " + websiteTitle);
		String expectedTitle = "My account - My Store";
		assertEquals(websiteTitle, expectedTitle);
	}
	
	public MyAccountPage verifyName() {
		String expectedName = "Auto Testing";
		String actualName = driver.findElement(accountUserName).getText();
		logger.info("UserName is:" + actualName);
		assertEquals(actualName, expectedName);
		return this;
	}
	
	public TShirtPage clickTshirt() {
		tool.clickButton(tShirtBtn);
		return new TShirtPage();
	}
}
