package com.mindtree.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.mindtree.reusablecomponents.WebDriverHelper;

public class ScreenShot {

	private WebDriver driver;
	private Logging logHelper = new Logging(this);
	private Logger logger = logHelper.CreateLogger();

	public void getScreenShot(String file) {
		driver = WebDriverHelper.getDriver();
		String filePath = ".\\SS\\" + file + CurrentTime.getTimestamp() + ".png";
		TakesScreenshot ScrnShot = (TakesScreenshot) driver;
		File SrcFile = ScrnShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(filePath);
		try {
			FileUtils.copyFile(SrcFile, DestFile);
			logger.info("Screen Shot Captured... Stored to " + filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
