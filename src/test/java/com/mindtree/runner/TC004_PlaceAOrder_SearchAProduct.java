package com.mindtree.runner;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mindtree.pageObjects.GiftPage;
import com.mindtree.pageObjects.HomePage;
import com.mindtree.pageObjects.SearchResultsPage;
import com.mindtree.reusablecomponents.WebDriverHelper;
import com.mindtree.utilities.Logging;
import com.mindtree.utilities.ScreenShot;

public class TC004_PlaceAOrder_SearchAProduct extends WebDriverHelper {
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
	public void searchAGift() {
		HomePage HP = new HomePage(driver);
		HP.getSearchBar().sendKeys("Harry Potter");
		HP.getSearchBar().sendKeys(Keys.ENTER);
		scrnShot.getScreenShot("TC004_SG_SearchCatalog");
		logger.info("Searched for a gift...");
	}

	@Test(dependsOnMethods = { "searchAGift" })
	public void selecttheGift() {
		SearchResultsPage SRP = new SearchResultsPage(driver);
		SRP.getGift("Harry Potter Pocket Watch Keychain").click();
		logger.info("Selected a gift...");
	}
	
	@Test(dependsOnMethods = { "selecttheGift" })
	public void addGiftToCart() {
		GiftPage GP = new GiftPage(driver);
		GP.getAddToCart().click();
		scrnShot.getScreenShot("TC004_SG_AddedtoCart");
		logger.info("Gift added to cart...");
	}

	@AfterClass
	public void endTest() {
		logger.info("TC004 Place Order by searching succesful...");
		driver.close();
		driver.quit();
	}
}
