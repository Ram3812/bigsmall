package com.mindtree.runner;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mindtree.pageObjects.GiftPage;
import com.mindtree.pageObjects.HomePage;
import com.mindtree.pageObjects.SearchResultsPage;
import com.mindtree.pageObjects.WishListPage;
import com.mindtree.reusablecomponents.WebDriverHelper;
import com.mindtree.utilities.Logging;
import com.mindtree.utilities.ScreenShot;

public class TC002_WishList_RemoveFromWishList extends WebDriverHelper {
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
		HP.getSearchBar().sendKeys("Disney");
		HP.getSearchBar().sendKeys(Keys.ENTER);
		scrnShot.getScreenShot("TC006_WLremove_SearchCatalog");
		logger.info("Searched for a gift...");
	}

	@Test(dependsOnMethods = { "searchAGift" })
	public void selecttheGift() {
		SearchResultsPage SRP = new SearchResultsPage(driver);
		SRP.getGift("Ariel Action Figure").click();
		logger.info("Selected a gift...");
	}
	
	@Test(dependsOnMethods = { "selecttheGift" })
	public void addGiftToWishlist() {
		GiftPage GP = new GiftPage(driver);
		GP.getAddToWishList().click();
		scrnShot.getScreenShot("TC006_WLremove_AddedtoWishList");
		logger.info("Gift added to wishlist...");
	}
	
	@Test(dependsOnMethods = { "addGiftToWishlist" })
	public void removeGiftFromWishlist() {
		HomePage HP = new HomePage(driver);
		HP.getWishListButton().click();
		logger.info("Navigated to Wish List...");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WishListPage WLP = new WishListPage(driver);
		wait.until(ExpectedConditions.visibilityOfAllElements(WLP.getWelcomeBtn()));
		WLP.getWelcomeBtn().click();
		Assert.assertTrue(WLP.getGifts() != 0);
		scrnShot.getScreenShot("TC006_WLremove_WishListPage");
		WLP.getRemove("Ariel Action Figure").click();
		scrnShot.getScreenShot("TC006_WLremove_GiftRemoved");
	}

	@AfterClass
	public void endTest() {
		logger.info("TC006 remove from WishList succesful...");
		driver.close();
		driver.quit();
	}
}
