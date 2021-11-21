package com.mindtree.UIstore;

import org.openqa.selenium.By;

public class InfoPageUI {
	protected static By email = By.id("checkout_email");
	protected static By Fname = By.id("checkout_shipping_address_first_name");
	protected static By Lname = By.id("checkout_shipping_address_last_name");
	protected static By address = By.id("checkout_shipping_address_address1");
	protected static By landmark = By.id("checkout_shipping_address_address2");
	protected static By city = By.id("checkout_shipping_address_city");
	protected static By country = By.id("checkout_shipping_address_country");
	protected static By state = By.id("checkout_shipping_address_province");
	protected static By pin = By.id("checkout_shipping_address_zip");
	protected static By phone = By.id("checkout_shipping_address_phone");
	protected static By continueShipping = By.id("continue_button");
}
