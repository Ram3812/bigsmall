package com.mindtree.UIstore;

import org.openqa.selenium.By;

public class WishListPageUI {
	protected static By gifts = By.cssSelector("li.swym-item");
	protected static By welcomeBtn = By.id("swym-welcome-button");
	protected static By removes = By.xpath("//li[@class='swym-remove']");
	protected static By addToCart = By.xpath("//a[text()='Add To Cart']");
	protected static By specificRemove = By.xpath(
			"//li[@class='swym-remove']/ancestor::ul[@class='swym-actions']/preceding-sibling::div[@class='swym-information']/div[@class='swym-title']/a");
	protected static By specificAddtocart = By.xpath(
			"//a[text()='Add To Cart']/ancestor::div[@class='swym-add-to-cart swym-background-color swym-loader']/preceding-sibling::div[@class='swym-information']/div[@class='swym-title']/a");
}
//li[@class='swym-remove']/ancestor::ul[@class='swym-actions']/preceding-sibling::div[@class='swym-information']/div[@class='swym-title']/a
//a[text()='Add To Cart']/ancestor::div[@class='swym-add-to-cart swym-background-color swym-loader']/preceding-sibling::div[@class='swym-information']/div[@class='swym-title']/a