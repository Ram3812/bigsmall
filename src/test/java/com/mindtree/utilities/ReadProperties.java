package com.mindtree.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperties {
	protected Properties prop;
	private FileInputStream FIS;
	public ReadProperties() {
		prop = new Properties();
		try {
			FIS = new FileInputStream(".\\config.properties");
			prop.load(FIS);
		} catch (Exception e) {
			System.out.println("Properties file not found:  " + e.getLocalizedMessage());
		}
	}	
}
