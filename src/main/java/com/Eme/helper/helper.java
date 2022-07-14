package com.Eme.helper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
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
	
	public static void waitForClick(WebDriver driver,WebElement element , int timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.click();
	}
	
	public static boolean checkInternet() {
		 try {
	         URL url = new URL(System.getProperty("url"));
	         URLConnection connection = url.openConnection();
	         connection.connect();
	         System.out.println("Internet is connected");
	      } catch (MalformedURLException e) {
	         System.out.println("Internet is not connected");
	      } catch (IOException e) {
	         System.out.println("Internet is not connected");
	      }
		return true;
	}
	
	public static String generateRandomVal() {
		int min = 200;  
		int max = 400; 
		int val = (int)(Math.random()*(max-min+1)+min);
		String dataval="test"+val;
		return dataval;	
	}
	
	/*
	 * public static void main(String args[]) {
	 * System.out.println(helper.checkInternet()); }
	 */
}
