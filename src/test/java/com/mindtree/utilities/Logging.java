package com.mindtree.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logging {
	public Logger logger;

	public Logging(Object obj) {
		logger = LogManager.getLogger(obj.getClass());
	}

	public Logger CreateLogger() {
		return logger;
	}
}
