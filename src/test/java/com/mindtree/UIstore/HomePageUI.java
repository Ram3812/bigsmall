package com.mindtree.UIstore;

import org.openqa.selenium.By;

public class HomePageUI {
	protected static By navObjects = By.cssSelector("a.site-nav__link");
	protected static By searchBar = By.xpath("//input[@type='search']");
	protected static By dropdown = By.cssSelector("li.site-nav__deep-dropdown-trigger");
	protected static By giftLink = By.cssSelector("a.site-nav__dropdown-link");
	protected static By WAclose = By.cssSelector("div.wa-optin-widget-close-btn");
}
