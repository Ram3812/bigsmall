package com.mindtree.UIstore;

import org.openqa.selenium.By;

public class GiftPageUI {
	protected static By logo = By.cssSelector("a.site-header__logo-link.logo--has-inverted");
	protected static By inputField = By.xpath("//label[contains(text(),'Enter Name')]/following-sibling::input");
	protected static By addToCart = By.xpath("//button[@type='submit']");
	protected static By addToWishList = By.cssSelector("button[class*='swym-add-to-wishlist']");
	protected static By popUp = By.cssSelector("a.swym-redirect");
}
