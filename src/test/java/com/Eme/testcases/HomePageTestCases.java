package com.Eme.testcases;
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
	
	@Test(priority = 1,enabled = true)
	public void logoClickActionTest() {
		reports.createTest("logoClickActionTest");
		boolean logores = homePage.isLogoClickable();
		Assert.assertEquals(logores, true);
	}
		
	@Test(priority = 2,enabled = true)
	public void helplinkTest() {
		reports.createTest("helplinkTest");
		boolean linkres = homePage.helplink();
		Assert.assertEquals(linkres, true);
	}
	
	@Test(priority = 3,enabled = true)
	public void cartPresence() {
		reports.createTest("cartPresence");
		boolean linkres = homePage.cart();
		Assert.assertEquals(linkres, true);
	}
	
	@Test(priority = 4,enabled = true)
	public void cartCountTest() {
		reports.createTest("cartCountTest");
		boolean linkres = homePage.isCartEmpty();
		Assert.assertEquals(linkres, true);
	}
	
	@Test(priority = 5,enabled = true)
	public void menuItemsTest() {
		reports.createTest("menuItemsTest");
		String menuit = homePage.getElementText();
		System.out.println(menuit.toCharArray());
		if (menuit.contains("EYEGLASSES")) {
			Assert.assertEquals(menuit, "EYEGLASSES,SUNGLASSES,CONTACT LENSES,COMPUTER GLASSES,READING GLASSES,POWER SUNGLASSES,MORE...,");
		}else {
			System.out.println("Menu items are mismatched or something went wrong..");
		}
		
	}
	
	@Test(priority = 6,enabled = true)
	public void searchresCountTest() {
		reports.createTest("searchresCountTest");
		int elementcount = homePage.countOfSearchResult();
		System.out.println(elementcount);
		Assert.assertEquals(elementcount, 36);
	}
	
	@Test(priority = 7,enabled = true)
	public void sortValTest() {
		reports.createTest("sortValTest");
		String elementsort = homePage.getSortvalues();
		System.out.println(elementsort);
		//Assert.assertEquals(elementcount, 36);
	}
}