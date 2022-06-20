package com.Eme.helper;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Eme.pages.BrowserManagement;
import com.github.dockerjava.api.model.Driver;

public class helper extends BrowserManagement {
	
	
	public static boolean clickElemenetTest(WebElement element) {
		if (element.isDisplayed() && element.isEnabled()) {
			element.click();
			return true;
		}else {
			return false;
		}
	}
	
	public static void scrollby(String toscroll) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(toscroll);	
	}
	
	public static void waitfornextAction(WebDriver driver, int timeout) {
		new WebDriverWait(driver, timeout);
	}
	
}
