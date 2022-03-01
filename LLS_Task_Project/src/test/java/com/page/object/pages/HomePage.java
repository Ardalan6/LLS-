package com.page.object.pages;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.page.object.libraries.Base;

public class HomePage extends Base{
	final static Logger logger = Logger.getLogger(HomePage.class);
	
	// Locators for 'LandingPage'
	By signInbtn = By.cssSelector("a.login");
	
	public HomePage() {
		String websiteTitle = driver.getTitle();
		logger.info("website title is: " + websiteTitle);
		String expectedTitle = "My Store";
		assertEquals(websiteTitle, expectedTitle);
	}
	
	public Signin_Page clickSignIn() {
		tool.clickButton(signInbtn);
		return new Signin_Page();
	}
}
