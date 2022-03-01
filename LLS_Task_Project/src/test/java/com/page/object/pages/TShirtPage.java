package com.page.object.pages;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.page.object.libraries.Base;

public class TShirtPage extends Base{
	final static Logger logger = Logger.getLogger(TShirtPage.class);
	
	// Locators for 'TShirtPage'
	By addToCartBtn = By.xpath("//span[text()='Add to cart']");
	By product = By.cssSelector(".product-container");
	By proceedBtn = By.cssSelector("a[title='Proceed to checkout']");
	By proceedBtn2 = By.cssSelector(".standard-checkout");
	
	public TShirtPage() {
		String websiteTitle = driver.getTitle();
		logger.info("website title is: " + websiteTitle);
		String expectedTitle = "T-shirts - My Store";
		assertEquals(websiteTitle, expectedTitle);
	}
	
	public TShirtPage addItemToCart() {
		tool.moveToElement(product);
		tool.clickButton(addToCartBtn);
		//span[text()='Add to cart']
		return this;
	}
	
	public ChangeAddressPage clickProceed() {
		tool.clickButton(proceedBtn);
		tool.dynamicWaitForPresenceOfElement(proceedBtn2);
		tool.clickButton(proceedBtn2);
		return new ChangeAddressPage();
	}
}
