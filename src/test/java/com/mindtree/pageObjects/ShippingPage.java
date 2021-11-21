package com.mindtree.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.UIstore.ShippingPageUI;

public class ShippingPage extends ShippingPageUI {
	private WebDriver driver;

	public ShippingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getShippingWithOlPay() {
		return driver.findElement(shipWithOlPay);
	}
	
	public WebElement getShippingWithCOD() {
		return driver.findElement(shipWithCOD);
	}
	
	public WebElement getContinueBtn() {
		return driver.findElement(continuePayment);
	}
	
}
