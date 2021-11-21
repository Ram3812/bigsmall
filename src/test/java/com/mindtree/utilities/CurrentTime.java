package com.mindtree.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentTime {
	public static String getTimestamp() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		return dateFormat.format(new Date());
	}
}
