package com.mindtree.UIstore;

import org.openqa.selenium.By;

public class GiftCardPageUI {
	protected static By rs500 = By.xpath(
			"//input[@id='ProductSelect-738195636312-option-title-Rs.+500']/ancestor::div[@class='variant-input']");
	protected static By rs1000 = By.xpath(
			"//input[@id='ProductSelect-738195636312-option-title-Rs.+1000']/ancestor::div[@class='variant-input']");
	protected static By rs2000 = By.xpath(
			"//input[@id='ProductSelect-738195636312-option-title-Rs.+2000']/ancestor::div[@class='variant-input']");
	protected static By rs5000 = By.xpath(
			"//input[@id='ProductSelect-738195636312-option-title-Rs.+5000']/ancestor::div[@class='variant-input']");
	protected static By rs10000 = By.xpath(
			"//input[@id='ProductSelect-738195636312-option-title-Rs.+10000']/ancestor::div[@class='variant-input']");
	protected static By addToCart = By.cssSelector("button[type='submit']");
}
