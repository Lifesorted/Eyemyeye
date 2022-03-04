package com.Eme.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Eme.pages.BrowserManagement;
import com.Eme.pages.HomePage;

public class HomePageTestCases extends BrowserManagement {

	@Test
	public void logoClickActionTest() {
		HomePage homePage = new HomePage(driver);
		boolean logores = homePage.isLogoClickable();
		Assert.assertEquals(logores, true);
	}

}