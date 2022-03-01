package com.page.object.pages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import com.page.object.libraries.Base;

public class CheckOutPage extends Base {
	final static Logger logger = Logger.getLogger(CheckOutPage.class);

	// Locators for 'CheckOutPage'
	By ProceedBtn = By.name("processAddress");
	By TermsCheckBox = By.id("cgv");
	By ProceedBtn2 = By.name("processCarrier");
	By PayByCheckBtn = By.cssSelector(".cheque");
	By ConfirmOrder = By.xpath("//span[text()='I confirm my order']");

	public CheckOutPage clickProceesBtn() {
		tool.clickButton(ProceedBtn);
		return this;
	}

	public CheckOutPage agreeTermsCheckBox() {
		tool.clickButton(TermsCheckBox);
		return this;
	}

	public CheckOutPage clickProceesBtn2() {
		tool.clickButton(ProceedBtn2);
		return this;
	}

	public CheckOutPage payByCheck() {
		tool.clickButton(PayByCheckBtn);
		return this;
	}

	public CheckOutPage clickConfirmOrder() {
		tool.clickButton(ConfirmOrder);
		return this;
	}

	public CheckOutPage writeConfirmationToExcel() throws IOException {
		String text = driver.findElement(By.cssSelector(".box.order-confirmation")).getText();
		logger.info("Confirmation text : " + text);
		FileInputStream fis = new FileInputStream("src/test/resources/TestData/TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		Row row = sheet.createRow(3);
		Cell cell = row.createCell(0);
		//cell.setCellType(cell.);
		cell.setCellValue(text);
		FileOutputStream fos = new FileOutputStream("src/test/resources/TestData/TestData.xlsx");
		workbook.write(fos);
		fos.close();
		workbook.close();
		return this;
	}
}
