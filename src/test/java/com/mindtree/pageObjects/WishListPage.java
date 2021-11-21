package com.mindtree.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.UIstore.WishListPageUI;

public class WishListPage extends WishListPageUI {
	private WebDriver driver;

	public WishListPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getWelcomeBtn() {
		return driver.findElement(welcomeBtn);
	}

	public int getGifts() {
		return driver.findElements(gifts).size();
	}

	public WebElement getRemove(String giftTitle) {
		List<WebElement> list = driver.findElements(removes);
		List<WebElement> L = driver.findElements(specificRemove);
		for (int i = 0; i < L.size(); i++) {
			if (L.get(i).getText().equalsIgnoreCase(giftTitle)) {
				return list.get(i);
			}
		}
		return null;
	}

	public WebElement getAddtoCart(String giftTitle) {
		List<WebElement> list = driver.findElements(addToCart);
		List<WebElement> L = driver.findElements(specificAddtocart);
		for (int i = 0; i < L.size(); i++) {
			if (L.get(i).getText().equalsIgnoreCase(giftTitle)) {
				return list.get(i);
			}
		}
		return null;
	}

	public List<WebElement> getAllGifts() {
		return driver.findElements(gifts);
	}
}
