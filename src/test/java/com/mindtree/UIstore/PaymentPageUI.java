package com.mindtree.UIstore;

import org.openqa.selenium.By;

public class PaymentPageUI {
	protected static By paytm = By.id("checkout_payment_gateway_6217662505");
	protected static By cashfree = By.id("checkout_payment_gateway_113114311");
	protected static By COD = By.id("checkout_payment_gateway_113047303");
	protected static By sameAddress = By.id("checkout_different_billing_address_false");
	protected static By diffAddress = By.id("checkout_different_billing_address_true");
	protected static By CompleteOrder = By.id("continue_button");
}
