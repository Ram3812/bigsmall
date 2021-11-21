package com.mindtree.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.UIstore.SearchResultsPageUI;

public class SearchResultsPage extends SearchResultsPageUI {
	private WebDriver driver;

	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getGift(String giftName) {
		List<WebElement> list = driver.findElements(gifts);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().equals(giftName)) {
				return list.get(i);
			}
		}
		return null;
	}
}
