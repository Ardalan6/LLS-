package com.page.object.pages;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.page.object.libraries.Base;

public class CreateAccountPage extends Base {
	final static Logger logger = Logger.getLogger(CreateAccountPage.class);

	// Locators for 'CreateAccountPage'
	By pageheadingTxt = By.xpath("//h1[text()='Create an account']");
	By customerFirstName = By.id("customer_firstname");
	By customerLastName = By.id("customer_lastname");
	By password = By.id("passwd");
	By FirstNameElem = By.id("firstname");
	By LastNameElem = By.id("lastname");
	By AddressElem = By.id("address1");
	By CityElem = By.id("city");
	By StateElem = By.id("id_state");
	By ZipElem = By.id("postcode");
	By PhoneElem = By.id("phone_mobile");
	By RegisterButton = By.id("submitAccount");

	public CreateAccountPage() {
		String pageHeading = driver.findElement(pageheadingTxt).getText();
		logger.info("Page Heading is: " + pageHeading);
		String expectedHeading = "CREATE AN ACCOUNT";
		assertEquals(pageHeading, expectedHeading);
	}

	public MyAccountPage createAccountWithInfo(String CustomerfirstName,String CustomerlastName,String Password,String FirstName,
			String LastName,String Address,String City,String State,String ZipCode,String PhoneNum) {
		tool.clickButton(By.id("uniform-id_gender1"));
		tool.enterText(customerFirstName, CustomerfirstName);
		tool.enterText(customerLastName, CustomerlastName);
		tool.enterText(password, Password);
		tool.enterText(FirstNameElem, FirstName);
		tool.enterText(LastNameElem, LastName);
		tool.enterText(AddressElem, Address);
		tool.enterText(CityElem, City);
		Select stateList = new Select(driver.findElement(StateElem));
		stateList.selectByVisibleText(State);
		tool.enterText(ZipElem, ZipCode);
		tool.enterText(PhoneElem, PhoneNum);
		tool.clickButton(RegisterButton);
		return new MyAccountPage();
	}
}
