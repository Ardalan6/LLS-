package com.page.object.pages;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.page.object.libraries.Base;

public class Signin_Page extends Base{
	final static Logger logger = Logger.getLogger(Signin_Page.class);
	
	// Locators for 'Signin_Page'
	By createButton = By.cssSelector("i.icon-user.left");
	By createEmailField = By.id("email_create");
	
	
	public Signin_Page() {
		String websiteTitle = driver.getTitle();
		logger.info("Website title is: " + websiteTitle);
		String expectedTitle = "Login - My Store";
		assertEquals(websiteTitle, expectedTitle);
	}
	
	public Signin_Page createEmail(String CreateAcccount) {
		driver.findElement(createEmailField).sendKeys(CreateAcccount);
		return this;
	}
	
	public CreateAccountPage clickCreatebutton() {
		driver.findElement(createButton).click();
		return new CreateAccountPage();
	}
}
