package com.mindtree.runner;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mindtree.pageObjects.GiftCardPage;
import com.mindtree.pageObjects.HomePage;
import com.mindtree.reusablecomponents.WebDriverHelper;
import com.mindtree.utilities.Logging;
import com.mindtree.utilities.ScreenShot;

public class TC001_GiftCard_BuyGiftCard extends WebDriverHelper {
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

	@Test(dependsOnMethods = { "openUrl" })
	public void selectGiftCard() {
		HomePage HP = new HomePage(driver);
		HP.getGiftCardButton().click();
		logger.info("Gift Card Page opened...");
		GiftCardPage GCP = new GiftCardPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.urlContains("card"));
		GCP.getRs2000().click();
		scrnShot.getScreenShot("TC010_GiftCard_SelectedWorth");
		logger.info("Selected gift card worth 2000...");
		GCP.getAddToCart().click();
		logger.info("Gift card added to cart...");
	}

	@AfterClass
	public void endTest() {
		logger.info("TC010 add Gift Card to cart succesful...");
		driver.close();
		driver.quit();
	}

}
