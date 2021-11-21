package com.mindtree.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.UIstore.InfoPageUI;

public class InfoPage extends InfoPageUI {
	private WebDriver driver;

	public InfoPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getFname() {
		return driver.findElement(Fname);
	}
	
	public WebElement getLname() {
		return driver.findElement(Lname);
	}
	
	public WebElement getAddress() {
		return driver.findElement(address);
	}
	
	public WebElement getLandmark() {
		return driver.findElement(landmark);
	}
	
	public WebElement getCity() {
		return driver.findElement(city);
	}
	
	public WebElement getCountry() {
		return driver.findElement(country);
	}
	
	public WebElement getState() {
		return driver.findElement(state);
	}
	
	public WebElement getPin() {
		return driver.findElement(pin);
	}
	
	public WebElement getPhone() {
		return driver.findElement(phone);
	}
	
	public WebElement getContinueBtn() {
		return driver.findElement(continueShipping);
	}
	
}
