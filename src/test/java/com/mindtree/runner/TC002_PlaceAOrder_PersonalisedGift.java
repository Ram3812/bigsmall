package com.mindtree.runner;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mindtree.pageObjects.GiftPage;
import com.mindtree.pageObjects.GiftsCatalogPage;
import com.mindtree.pageObjects.HomePage;
import com.mindtree.reusablecomponents.WebDriverHelper;
import com.mindtree.utilities.Logging;
import com.mindtree.utilities.ScreenShot;

public class TC002_PlaceAOrder_PersonalisedGift extends WebDriverHelper {
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
	public void selectGift_PersonalizedGift() {
		HomePage HP = new HomePage(driver);
		HP.getPersonalizedGiftButton().click();
		logger.info("Clicked on Personalized Gift button...");
		GiftsCatalogPage GCP = new GiftsCatalogPage(driver);
		GCP.getGift("Personalized Wonder Woman Themed Nameplate | COD not available").click();
		logger.info("Selected the gift...");
	}

	@Test(dependsOnMethods = { "selectGift_PersonalizedGift" })
	public void placeOrder_PersonalizedGift() {
		GiftPage GP = new GiftPage(driver);
		GP.getInputField().sendKeys("Ram");
		scrnShot.getScreenShot("TC002_PG_FilledPersonalizedData");
		GP.getAddToCart().click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.invisibilityOf(GP.getAddToCart()));
		scrnShot.getScreenShot("TC002_PG_CartPageDisplaed");
		logger.info("Given personalized data and added to cart...");
	}

	@AfterClass
	public void endTest() {
		logger.info("TC002 Place Order Personalized Gift succesful...");
		driver.close();
		driver.quit();
	}

}
