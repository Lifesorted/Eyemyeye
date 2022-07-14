package com.Eme.testcases;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.Eme.helper.DataSlayer;
import com.Eme.pages.BrowserManagement;
import com.Eme.pages.LoginPage;


public class LoginPageTestCases extends BrowserManagement {

	LoginPage loginpage;
	
	@BeforeMethod
	public void initializewebElement() {
		loginpage=new LoginPage();
	}
	
	@Test(description = "Login with password",enabled = false)
	public void LoginTest_001() {
		boolean signinstatus=loginpage.loginByPass(DataSlayer.getData(1, 0, 1), DataSlayer.getData(1, 1, 1));
		Assert.assertEquals(signinstatus, true);
	}
	
	@Test(description = "Close login popup", enabled = false)
	public void LoginTest_002() {
		boolean crossstatus=loginpage.isLoginPopupClose();
		Assert.assertEquals(crossstatus, true);
	}
	
	@Test(description = "Login by Otp", enabled = false)
	public void LoginTest_003() {
		boolean crossstatus=loginpage.loginByOtp("9582957891", "1234");
		Assert.assertEquals(crossstatus, true);
	}
	
	@Test(description = "Resend Otp", enabled = false)
	public void LoginTest_004() {
		boolean clickval=loginpage.resendOtp("9582957891");
		Assert.assertEquals(clickval, true);
	}
	
	@Test(description = "Forget password", enabled = false)
	public void LoginTest_005() {
		loginpage.forgetPassword(DataSlayer.getData(1, 0, 1), DataSlayer.getData(1, 2, 1));
	}
	
	@Test(description = "Eyeicon Click", enabled = true)
	public void LoginTest_006() {
		boolean eyeiconisclicked= loginpage.showPassword(DataSlayer.getData(1, 0, 1), DataSlayer.getData(1, 1, 1));
		Assert.assertEquals(eyeiconisclicked, true);
	}
}
