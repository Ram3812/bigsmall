package com.mindtree.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.UIstore.HomePageUI;

public class HomePage extends HomePageUI {
	private WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getCorporateGiftButton() {
		List<WebElement> list = driver.findElements(navObjects);
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getText().equalsIgnoreCase("Corporate Gifts"))
				return list.get(i);
		}
		return null;
	}
	
	public WebElement getPersonalizedGiftButton() {
		List<WebElement> list = driver.findElements(navObjects);
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getText().equalsIgnoreCase("Personalized Gifts"))
				return list.get(i);
		}
		return null;
	}
	
	public WebElement getChristmasGiftButton() {
		List<WebElement> list = driver.findElements(navObjects);
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getText().equalsIgnoreCase("Christmas Gifts"))
				return list.get(i);
		}
		return null;
	}
	
	public WebElement getBirthdayGiftButton() {
		List<WebElement> list = driver.findElements(navObjects);
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getText().equalsIgnoreCase("Birthday Gifts"))
				return list.get(i);
		}
		return null;
	}
	
	public WebElement getSignInButton() {
		List<WebElement> list = driver.findElements(navObjects);
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getText().equalsIgnoreCase("sign in"))
				return list.get(i);
		}
		return null;
	}
	
	public WebElement getWishListButton() {
		List<WebElement> list = driver.findElements(navObjects);
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getText().equalsIgnoreCase("wish list"))
				return list.get(i);
		}
		return null;
	}
	
	public WebElement getGiftCardButton() {
		List<WebElement> list = driver.findElements(navObjects);
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getText().equalsIgnoreCase("gift card"))
				return list.get(i);
		}
		return null;
	}
	
	public WebElement getCartButton() {
		List<WebElement> list = driver.findElements(navObjects);
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getText().equalsIgnoreCase("cart"))
				return list.get(i);
		}
		return null;
	}
	
	public WebElement getSearchBar() {
		return driver.findElement(searchBar);
	}
	
	public WebElement getDropdown(String categName) {
		List<WebElement> list = driver.findElements(dropdown);
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getText().equalsIgnoreCase(categName))
				return list.get(i);
		}
		return null;
	}
	
	public WebElement getCateg(String giftName) {
		List<WebElement> list = driver.findElements(giftLink);
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getText().equalsIgnoreCase(giftName))
				return list.get(i);
		}
		return null;
	}
	
	public WebElement getWaClose() {
		return driver.findElement(WAclose);
	}
}
