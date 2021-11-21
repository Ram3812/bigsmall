package com.mindtree.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.UIstore.GiftPageUI;

public class GiftPage extends GiftPageUI {
	private WebDriver driver;

	public GiftPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getLogo() {
		return driver.findElement(logo);
	}

	public WebElement getInputField() {
		return driver.findElement(inputField);
	}

	public WebElement getAddToCart() {
		List<WebElement> list = driver.findElements(addToCart);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().equalsIgnoreCase("Add to Cart")) {
				return list.get(i);
			}
		}
		return null;
	}

	public WebElement getAddToWishList() {
		return driver.findElement(addToWishList);
	}

	public WebElement getpopUp() {
		return driver.findElement(popUp);
	}

}
