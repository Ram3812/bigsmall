package com.mindtree.runner;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mindtree.pageObjects.Cart;
import com.mindtree.pageObjects.GiftPage;
import com.mindtree.pageObjects.GiftsCatalogPage;
import com.mindtree.pageObjects.HomePage;
import com.mindtree.pageObjects.InfoPage;
import com.mindtree.pageObjects.PaymentPage;
import com.mindtree.pageObjects.ShippingPage;
import com.mindtree.reusablecomponents.WebDriverHelper;
import com.mindtree.utilities.Logging;
import com.mindtree.utilities.ScreenShot;

public class TC001_Cart_CheckOut extends WebDriverHelper {
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
	public void selectGift() {
		HomePage HP = new HomePage(driver);
		HP.getChristmasGiftButton().click();
		logger.info("Clicked on Christmas Gift button...");
		GiftsCatalogPage GCP = new GiftsCatalogPage(driver);
		GCP.getGift("Christmas Socks").click();
		logger.info("Selected the gift...");
	}

	@Test(dependsOnMethods = { "selectGift" })
	public void addGiftToCart() {
		GiftPage GP = new GiftPage(driver);
		GP.getAddToCart().click();
		scrnShot.getScreenShot("TC008_CartCheckout_CartPage");
		logger.info("Gift added to cart...");
	}

	@Test(dependsOnMethods = { "addGiftToCart" })
	public void clickOnCheckOut() {
		logger.info("Cart Opened...");
		Cart C = new Cart(driver);
		C.getCheckOutBtn().click();
		logger.info("Clicked on checkout...");
		HomePage HP = new HomePage(driver);
		HP.getWaClose().click();
	}

	@Test(dependsOnMethods = { "clickOnCheckOut" })
	public void fillInfo() {
		InfoPage IP = new InfoPage(driver);
		IP.getEmail().sendKeys("sdet.ram@gmail.com");
		IP.getFname().sendKeys("Sri");
		IP.getLname().sendKeys("Ram");
		IP.getAddress().sendKeys("39-4-18, Murali Nagar");
		IP.getLandmark().sendKeys("SBI");
		IP.getCity().sendKeys("Vizag");
		Select country = new Select(IP.getCountry());
		country.selectByValue("India");
		Select state = new Select(IP.getState());
		state.selectByValue("AP");
		IP.getPin().sendKeys("530007");
		IP.getPhone().sendKeys("9502237082");
		scrnShot.getScreenShot("TC008_CartCheckout_InfoPage");
		IP.getContinueBtn().click();
		logger.info("Address details filled...");
	}

	@Test(dependsOnMethods = { "fillInfo" })
	public void chooseShippingPay() {
		ShippingPage SP = new ShippingPage(driver);
		SP.getShippingWithOlPay().click();
		scrnShot.getScreenShot("TC008_CartCheckout_ShippingPage");
		SP.getContinueBtn().click();
		logger.info("Chose online paymeny...");
		PaymentPage PP = new PaymentPage(driver);
		PP.getPaytm().click();
		PP.getSameAddress().click();
		scrnShot.getScreenShot("TC008_CartCheckout_PaymentPage");
		PP.getCompleteBtn().click();
		logger.info("Chose paytm and finished order...");
	}

	@AfterClass
	public void endTest() {
		logger.info("TC008 Cart Checkout succesful...");
		driver.close();
		driver.quit();
	}

}
