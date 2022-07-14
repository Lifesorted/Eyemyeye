package com.Eme.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Eme.helper.helper;

public class LoginPage extends BrowserManagement {

	public LoginPage() {
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class=\"cont_signin\"]")
	WebElement Loginlink;
	
	@FindBy(xpath = "//input[@id=\"userinput\"]")
	WebElement emailinput;
	
	@FindBy(xpath = "//button[@class=\"btn btn-success btn-block\"]/child::span")
	WebElement proceedbtn1;
	
	@FindBy(xpath = "//input[@id=\"password\"]")
	WebElement passwordinput;
	
	@FindBy(xpath="//a[contains(text(),'Use Password?')]")
	WebElement userpassword;
	
	@FindBy(xpath = "//form[@class=\"form-signin form-height-lg cwAuthForm hidden form-code-2010 form-code-2017 ng-pristine ng-valid\"]/child::button")
	WebElement proceedbtn;
	
	@FindBy(xpath = "//span[@class=\"signin_icon\"]")
	WebElement signinicon;
	
	@FindBy(xpath = "//button[@class=\"close\"]/child::span")
	WebElement logincrossbtn;
	
	@FindBy(xpath = "//form[@method=\"post\"]/child::input[@id=\"otp\"]")
	WebElement otpinput;
	
	@FindBy(xpath = "//button[text()=\"Verify\"]")
	WebElement verifybtn;
	
	@FindBy(xpath = "//a[text()=\"Resend Code\"]")
	WebElement resendbtn;
	
	@FindBy(xpath = "//a[text()=\"Forgot Password?\"]")
	WebElement forgetpass;
	
	@FindBy(xpath = "//input[@id=\"passwordnew\"]")
	WebElement passnew;
	
	@FindBy(xpath = "//button[text()=\" Update \"]")
	WebElement updatepassbtn;
	
	@FindBy(xpath = "//div[@class=\"psd-wrap\"]/child::i[@toggle=\"#password\"]")
	WebElement eyeicon;
	
	public boolean loginByPass(String username, String password) {
		if (Loginlink.isDisplayed()) {
            Loginlink.click();
			emailinput.sendKeys(username);
			emailinput.sendKeys(Keys.ENTER);
			//helper.waitForClick(driver, proceedbtn1, 3000);
			try {
				helper.waitForClick(driver, userpassword, 3000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			passwordinput.sendKeys(password);
			proceedbtn.click();
			signinicon.isDisplayed();
		} else {
            System.out.println("Element not displayed");
		}
		return true;
	}
	
	public boolean isLoginPopupClose() {
		if (Loginlink.isDisplayed() && Loginlink.isEnabled()) {
			Loginlink.click();
			logincrossbtn.click();
		}else {
			System.out.println("Login link not displayed");
		}
		return true;
	}
	
	public boolean loginByOtp(String username, String otp) {
		if (Loginlink.isDisplayed() && Loginlink.isEnabled()) {
			Loginlink.click();
			emailinput.sendKeys(username);
			emailinput.sendKeys(Keys.ENTER);
			otpinput.sendKeys(otp);
			verifybtn.click();
		}else {
			System.out.println("Login link not displayed");
		}
		return true;
	}
	
	public boolean resendOtp(String username) {
		boolean isclick=false;
		if (helper.checkInternet()) {
			Loginlink.click();
			emailinput.sendKeys(username);
			emailinput.sendKeys(Keys.ENTER);
			helper.waitForClick(driver, resendbtn, 5000);
			isclick=true;
		} else {
            System.out.println("No Internet connectivity");
		}
		return isclick;
	}
	
	public void forgetPassword(String username, String otp) {
		if (helper.checkInternet()) {
            Loginlink.click();
			emailinput.sendKeys(username);
			emailinput.sendKeys(Keys.ENTER);
			//helper.waitForClick(driver, proceedbtn1, 3000);
			try {
				helper.waitForClick(driver, userpassword, 3000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			helper.waitForClick(driver, forgetpass, 3000);
			//forgetpass.click();
			otpinput.sendKeys(otp);
			String updatedpass=helper.generateRandomVal();
			passnew.sendKeys(updatedpass);
			updatepassbtn.click();
			helper.waitfornextAction(driver, 3000);
			passwordinput.sendKeys(updatedpass);
			System.out.println(updatedpass);
			helper.waitForClick(driver, proceedbtn, 3000);
		}else {
			System.out.println("Something went wrong!!");
		}
	}
	
	public boolean showPassword(String username, String password) {
		Loginlink.click();
		emailinput.sendKeys(username);
		emailinput.sendKeys(Keys.ENTER);
		try {
			helper.waitForClick(driver, userpassword, 3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		passwordinput.sendKeys(password);
		eyeicon.click();
		return true;
	}
}
