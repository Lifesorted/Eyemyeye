 package com.Eme.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class=\"logo\"]/child::a")
	WebElement logo;

	//logo
	public boolean isLogoClickable() {
		if (logo.isDisplayed()) {
			logo.click();
		} else {
			System.out.println("Logo not present");
		}
		return true;
	}

}
