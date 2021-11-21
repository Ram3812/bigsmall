package com.mindtree.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.UIstore.CartUI;

public class Cart extends CartUI {
	private WebDriver driver;

	public Cart(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getCheckOutBtn() {
		return driver.findElement(checkOutBtn);
	}

	public WebElement getMessage() {
		return driver.findElement(empty);
	}

	public WebElement getRemove(String giftTitle) {
		List<WebElement> list = driver.findElements(removeBtn);
		List<WebElement> L = driver.findElements(SpecificRemove);
		for (int i = 0; i < L.size(); i++) {
			if (L.get(i).getAttribute("textContent").equalsIgnoreCase(giftTitle))
				return list.get(i);
		}
		return list.get(0);
	}
}
