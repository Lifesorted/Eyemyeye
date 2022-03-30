package com.Eme.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Eme.helper.helper;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class=\"logo\"]/child::a")
	WebElement logo;
	
	@FindBy(xpath = "//a[@href=\"/help/\"]")
	static WebElement helplink;
	
	@FindBy(xpath = "//div[@id=\"singnIN\"]")
	WebElement signin;
	
	@FindBy(xpath = "//span[@class=\"cart_icon\"]")
	WebElement carticon;
	
	@FindBy(xpath = "//div[@class=\"new-count\"]")
	WebElement cartcount;
	
	@FindBy(xpath = "//h6[@class=\"font-size-base mb-4 text-center\"]")
	WebElement cartcounttext;

	// Logo click test
	public boolean isLogoClickable() {
		boolean result= helper.clickElemenetTest(logo);
		return result;
	}
	
	public boolean helplink() {
		boolean result= helper.clickElemenetTest(helplink);
		return result;
	}
	
	public boolean cart() {
		boolean result= helper.clickElemenetTest(carticon);
		return result;
	}
	
	public boolean isCartEmpty() {
		int cartnum=Integer.parseInt(cartcount.getText()); 
		if (cartnum==0) {
			cart();
			cartcounttext.isDisplayed();
			return true;
		}else {
			return false;
		}
		
	}

}
