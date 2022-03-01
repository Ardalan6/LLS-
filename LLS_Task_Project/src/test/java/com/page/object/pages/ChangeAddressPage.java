package com.page.object.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.page.object.libraries.Base;

public class ChangeAddressPage extends Base{
	final static Logger logger = Logger.getLogger(ChangeAddressPage.class);
	
	// Locators for 'ChangeAddressPage'
	By addNewAddress = By.xpath("//span[text()='Add a new address']");
	By AddressElem = By.id("address1");
	By CityElem = By.id("city");
	By StateElem = By.id("id_state");
	By ZipElem = By.id("postcode");
	By PhoneElem = By.id("phone_mobile");
	By SaveBtn = By.id("submitAddress");
	By addressTitle = By.id("alias");
	
	public ChangeAddressPage clickAddNewAddressBtn() {
		tool.clickButton(addNewAddress);
		return this;
	}
	
	public ChangeAddressPage enterNewAddressInfo(String Address2, String City2,String State2,String ZipCode2,String PhoneNum2) {
		tool.enterText(AddressElem, Address2);
		tool.enterText(CityElem, City2);
		Select stateList = new Select(driver.findElement(StateElem));
		stateList.selectByVisibleText(State2);
		tool.enterText(ZipElem, ZipCode2);
		tool.enterText(PhoneElem, PhoneNum2);
		tool.enterText(addressTitle, "New Address");
		return this;
	}
	
	public CheckOutPage clickSaveBtn() {
		tool.clickButton(SaveBtn);
		return new CheckOutPage();
	}
}
