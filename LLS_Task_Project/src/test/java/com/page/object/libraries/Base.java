package com.page.object.libraries;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {

	final static Logger logger = Logger.getLogger(Base.class);

	private String URL = "http://automationpractice.com/index.php";
	public static WebDriver driver;
	int defaultWaitTimeInSecs = 10;
	public static Tool tool;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
		tool = new Tool();
		driver = new ChromeDriver();
		logger.info("starting 'Chrome' browser.");
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(defaultWaitTimeInSecs, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(defaultWaitTimeInSecs, TimeUnit.SECONDS);
		logger.info("Maximizing the browser.");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}

	@AfterMethod
	public void tearDown() {
		logger.info("test ended. ");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (driver != null) {
			driver.close();
		}

	}

	@AfterClass
	public void cleanUpAfterAllTestMethods() {
		logger.info("After Class ...");
		if (driver != null) {
			driver.quit();
		}
	}

}