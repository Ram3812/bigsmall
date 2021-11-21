package com.mindtree.runner;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mindtree.pageObjects.CorporateGiftsPage;
import com.mindtree.pageObjects.HomePage;
import com.mindtree.reusablecomponents.WebDriverHelper;
import com.mindtree.utilities.Logging;
import com.mindtree.utilities.ReadExcell;
import com.mindtree.utilities.ScreenShot;

public class TC001_PlaceAOrder_CorporateGift extends WebDriverHelper {
	public WebDriver driver;
	public Logging logHelper = new Logging(this);
	public Logger logger = logHelper.CreateLogger();
	public ScreenShot scrnShot = new ScreenShot();

	@BeforeClass
	public void initDriver() {
		driver = initialiseDriver();
		logger.info("Driver initialized...");
	}

	@Test
	public void openUrl() {
		String url = prop.getProperty("url");
		driver.get(url);
		driver.manage().window().maximize();
		logger.info("Browser opened and navigated to URL...");
	}

	@Test(dependsOnMethods = { "openUrl" }, dataProvider = "getInfo")
	public void placeOrder_CorporateGift(String name, String email, String phone, String msg) {
		HomePage HP = new HomePage(driver);
		HP.getCorporateGiftButton().click();
		logger.info("Clicked on Corporate Gifts button...");
		CorporateGiftsPage CGP = new CorporateGiftsPage(driver);
		CGP.getNameField().sendKeys(name);
		CGP.getEmailField().sendKeys(email);
		CGP.getPhoneField().sendKeys(phone);
		CGP.getMessageField().sendKeys(msg);
		logger.info("Filled the detailes...");
		scrnShot.getScreenShot("TC001_CG_FilledForm");
		CGP.getSubmitBtn().click();
		logger.info("Submitted the details for Corporate Gifts...");
	}

	@Test(dependsOnMethods = { "placeOrder_CorporateGift" })
	public void verify_placedOrder() {
		logger.info("Validating the success text...");
		CorporateGiftsPage CGP = new CorporateGiftsPage(driver);
		CGP.getSuccessMsg();
		Assert.assertEquals(CGP.getSuccessMsg(),
				"Thanks for contacting us. We'll get back to you as soon as possible.");
		logger.info("Validated the success message...");
	}
	
	@DataProvider
	public Object[][] getInfo() {
		String file = prop.getProperty("testData");
		return ReadExcell.getCorpDetailes(file);
	}

	@AfterClass
	public void endTest() {
		logger.info("TC001 Place A Order Corporate Gift Successful...");
		driver.close();
		driver.quit();
	}
}