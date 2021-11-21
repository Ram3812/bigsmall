package com.mindtree.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.UIstore.CorporateGiftsPageUI;

public class CorporateGiftsPage extends CorporateGiftsPageUI {
	private WebDriver driver;

	public CorporateGiftsPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getNameField() {
		return driver.findElement(name);
	}

	public WebElement getEmailField() {
		return driver.findElement(email);
	}

	public WebElement getPhoneField() {
		return driver.findElement(phone);
	}

	public WebElement getMessageField() {
		return driver.findElement(message);
	}

	public WebElement getSubmitBtn() {
		return driver.findElement(submit);
	}
	
	public String getSuccessMsg() {
		return driver.findElement(messageText).getText();
	}

}
