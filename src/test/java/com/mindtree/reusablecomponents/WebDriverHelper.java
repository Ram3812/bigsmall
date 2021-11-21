package com.mindtree.reusablecomponents;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.mindtree.utilities.ReadProperties;

public class WebDriverHelper extends ReadProperties {

	protected static WebDriver driver;

	public WebDriver initialiseDriver() {
		String browser = prop.getProperty("browser");
		String driverName = "";
		if (browser.equalsIgnoreCase("firefox")) {
			driverName = ".\\BrowserDrivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", driverName);
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driverName = ".\\BrowserDrivers\\msedgedriver.exe";
			System.setProperty("webdriver.edge.driver", driverName);
			driver = new EdgeDriver();
		} else {
			driverName = ".\\BrowserDrivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", driverName);
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		return driver;
	}

	public static WebDriver getDriver() {
		return driver;
	}

}
