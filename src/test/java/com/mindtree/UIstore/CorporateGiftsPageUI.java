package com.mindtree.UIstore;

import org.openqa.selenium.By;

public class CorporateGiftsPageUI {
	protected static By name = By.id("contactFormName");
	protected static By email = By.id("contactFormEmail");
	protected static By phone = By.id("contactFormPhone");
	protected static By message = By.id("contactFormMessage");
	protected static By submit = By.cssSelector("input[type='submit']");
	protected static By messageText = By.cssSelector("p.note.form-success");
}
