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
	
	@Test(priority = 0,enabled = true)
	public void cartCountTest() {
		boolean linkres = homePage.isCartEmpty();
		Assert.assertEquals(linkres, true);
	}
	
}