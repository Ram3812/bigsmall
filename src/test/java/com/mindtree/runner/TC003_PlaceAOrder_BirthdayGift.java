package com.mindtree.runner;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mindtree.pageObjects.GiftPage;
import com.mindtree.pageObjects.GiftsCatalogPage;
import com.mindtree.pageObjects.HomePage;
import com.mindtree.reusablecomponents.WebDriverHelper;
import com.mindtree.utilities.Logging;
import com.mindtree.utilities.ScreenShot;

public class TC003_PlaceAOrder_BirthdayGift extends WebDriverHelper {
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
	public void selectGiftCateg_BirthdayGift() {
		HomePage HP = new HomePage(driver);
		Actions action = new Actions(driver);
		action.moveToElement(HP.getBirthdayGiftButton()).perform();
		action.moveToElement(HP.getDropdown("Birthday Gifts by Relationship")).perform();
		scrnShot.getScreenShot("TC003_BG_HoveredBirthdayGift");
		HP.getCateg("Birthday Gifts for Friends").click();
		logger.info("Selected 'Birthday gifts for friends'...");
	}

	@Test(dependsOnMethods = { "selectGiftCateg_BirthdayGift" })
	public void selectGift_Birthdaygift() {
		GiftsCatalogPage GCP = new GiftsCatalogPage(driver);
		GCP.getGift("3D Plush Frog Eye Mask").click();
		logger.info("Choosed '3D Plush Frog Eye Mask'....");
	}

	@Test(dependsOnMethods = { "selectGift_Birthdaygift" })
	public void placeOrder_Birthdaygift() {
		GiftPage GP = new GiftPage(driver);
		GP.getAddToCart().click();
		scrnShot.getScreenShot("TC003_BG_ClicledOnAddtoCart");
		logger.info("Added to Cart...");
	}

	@AfterClass
	public void endTest() {
		logger.info("TC003 Place Order Birthday Gift succesful...");
		driver.close();
		driver.quit();
	}
}
