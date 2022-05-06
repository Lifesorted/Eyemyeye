package com.Eme.testcases;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.Eme.pages.BrowserManagement;
import com.Eme.pages.HomePage;

public class HomePageTestCases extends BrowserManagement {

	HomePage homePage;
	
	@BeforeMethod
	public void initializeObjects() {
		homePage=new HomePage(driver);
	}
	
	@Test(priority = 1,enabled = false)
	public void logoClickActionTest() {
		boolean logores = homePage.isLogoClickable();
		Assert.assertEquals(logores, true);
	}
		
	@Test(priority = 1,enabled = false)
	public void helplinkTest() {
		boolean linkres = homePage.helplink();
		Assert.assertEquals(linkres, true);
	}
	
	@Test(priority = 1,enabled = false)
	public void cartPresence() {
		boolean linkres = homePage.cart();
		Assert.assertEquals(linkres, true);
	}
	
	@Test(priority = 0,enabled = false)
	public void cartCountTest() {
		boolean linkres = homePage.isCartEmpty();
		Assert.assertEquals(linkres, true);
	}
	
	@Test(priority = 0,enabled = false)
	public void menuItemsTest() {
		String menuit = homePage.getElementText();
		System.out.println(menuit.toCharArray());
		if (menuit.contains("EYEGLASSES")) {
			Assert.assertEquals(menuit, "EYEGLASSES,SUNGLASSES,CONTACT LENSES,COMPUTER GLASSES,READING GLASSES,POWER SUNGLASSES,MORE...,");
		}else {
			System.out.println("Menu items are mismatched or something went wrong..");
		}
		
	}
	
	@Test(priority = 0,enabled = true)
	public void searchresCountTest() {
		int elementcount = homePage.countOfSearchResult();
		System.out.println(elementcount);
		Assert.assertEquals(elementcount, 36);
	}
	
	@Test(priority = 0,enabled = false)
	public void sortValTest() {
		String elementsort = homePage.getSortvalues();
		System.out.println(elementsort);
		//Assert.assertEquals(elementcount, 36);
	}
}