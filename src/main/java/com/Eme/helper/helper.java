package com.Eme.helper;

import org.openqa.selenium.WebElement;

public class helper {
	
	public static boolean clickElemenetTest(WebElement element) {
		if (element.isDisplayed() && element.isEnabled()) {
			element.click();
			return true;
		}else {
			return false;
		}
	}

}
