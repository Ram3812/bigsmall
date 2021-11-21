package com.mindtree.runner;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mindtree.pageObjects.Cart;
import com.mindtree.pageObjects.GiftPage;
import com.mindtree.pageObjects.GiftsCatalogPage;
import com.mindtree.pageObjects.HomePage;
import com.mindtree.reusablecomponents.WebDriverHelper;
import com.mindtree.utilities.Logging;
import com.mindtree.utilities.ScreenShot;

public class TC002_Cart_RemoveFromCart extends WebDriverHelper {
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
	public void selectGiftAddToCart() {
		HomePage HP = new HomePage(driver);
		Actions action = new Actions(driver);
		action.moveToElement(HP.getBirthdayGiftButton()).perform();
		action.moveToElement(HP.getDropdown("Birthday Gifts by Price")).perform();
		HP.getCateg("Premium Birthday Gifts").click();
		logger.info("Selected 'Premium Birthday gifts'...");
		GiftsCatalogPage GCP = new GiftsCatalogPage(driver);
		GCP.getGift("Bonsai Tree LED Lamp").click();
		logger.info("Choosed 'Bonsai Tree LED Lamp'....");
		GiftPage GP = new GiftPage(driver);
		GP.getAddToCart().click();
		scrnShot.getScreenShot("TC009_CartRemove_AddedtoCart");
		logger.info("Added to Cart...");
	}

	@Test(dependsOnMethods = { "selectGiftAddToCart" })
	public void removeGift() {
		Cart C = new Cart(driver);
		C.getRemove("Bonsai Tree LED Lamp").click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(C.getMessage()));
		scrnShot.getScreenShot("TC009_CartRemove_CartEmpty");
		logger.info("Removed gift from cart...");
	}

	@AfterClass
	public void endTest() {
		logger.info("TC009 remove Gift from cart succesful...");
		driver.close();
		driver.quit();
	}
}