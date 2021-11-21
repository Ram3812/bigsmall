package com.mindtree.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.UIstore.PaymentPageUI;

public class PaymentPage extends PaymentPageUI {
	private WebDriver driver;

	public PaymentPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getPaytm() {
		return driver.findElement(paytm);
	}
	
	public WebElement getCashfree() {
		return driver.findElement(cashfree);
	}
	
	public WebElement getCOD() {
		return driver.findElement(COD);
	}
	
	public WebElement getSameAddress() {
		return driver.findElement(sameAddress);
	}
	
	public WebElement getDiffAddress() {
		return driver.findElement(diffAddress);
	}
	
	public WebElement getCompleteBtn() {
		return driver.findElement(CompleteOrder);
	}
	
}
