package com.page.object.tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.page.object.libraries.Base;
import com.page.object.libraries.ExcelManager;
import com.page.object.pages.HomePage;

public class Task_One_Test extends Base{

	@Test(dataProvider = "dataDrivenTest")
	public void dataDrivenTest(String CreateAcccount,String CustomerfirstName,String CustomerlastName,String Password,
			String FirstName,String LastName,String Address,String City,String State,String ZipCode,String PhoneNum,
			String Address2,String City2,String State2,String ZipCode2,String PhoneNum2) throws IOException {
		HomePage homePage = new HomePage();
		
		homePage.clickSignIn()
		.createEmail(CreateAcccount).clickCreatebutton()
		.createAccountWithInfo(CustomerfirstName,
				CustomerlastName,
				Password,
				FirstName,
				LastName,
				Address,
				City,
				State,
				ZipCode,
				PhoneNum)
		.verifyName()
		.clickTshirt()
		.addItemToCart()
		.clickProceed()
		.clickAddNewAddressBtn()
		.enterNewAddressInfo(Address2, 
				City2,
				State2,
				ZipCode2,
				PhoneNum2)
		.clickSaveBtn()
		.clickProceesBtn()
		.agreeTermsCheckBox()
		.clickProceesBtn2()
		.payByCheck()
		.clickConfirmOrder()
		.writeConfirmationToExcel();
	}
	
	@DataProvider(name = "dataDrivenTest")
	public Object[][] testData(){
		String excelFile = "src/test/resources/TestData/TestData.xlsx";

		Object[][] data = null;
		ExcelManager excel = new ExcelManager(excelFile, 0);
		data = excel.getExcelData();

		return data;
	}
}
