package com.mindtree.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.UIstore.GiftCardPageUI;

public class GiftCardPage extends GiftCardPageUI {
	private WebDriver driver;

	public GiftCardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getRs500() {
		return driver.findElement(rs500);
	}
	
	public WebElement getRs1000() {
		return driver.findElement(rs1000);
	}
	
	public WebElement getRs2000() {
		return driver.findElement(rs2000);
	}
	
	public WebElement getRs5000() {
		return driver.findElement(rs5000);
	}
	
	public WebElement getRs10000() {
		return driver.findElement(rs10000);
	}
	
	public WebElement getAddToCart() {
		List<WebElement> list = driver.findElements(addToCart);
		for (WebElement webElement : list) {
			if(webElement.getText().equalsIgnoreCase("Add To Cart"))
				return webElement;
		}
		return null;
	}
}
