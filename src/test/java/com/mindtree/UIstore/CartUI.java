package com.mindtree.UIstore;

import org.openqa.selenium.By;

public class CartUI {
	protected static By checkOutBtn = By.cssSelector("button[class*='cart__checkout']");
	protected static By removeBtn = By.cssSelector("button.cart__remove.text-link");
	protected static By empty = By.cssSelector("h2.basket__empty-title");
	protected static By SpecificRemove = By.xpath(
			"//button[@class='cart__remove text-link']/ancestor::div[@class='grid__item one-quarter text-right']/preceding-sibling::div/a[@class='cart__product-name']");
}
