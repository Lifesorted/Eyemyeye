package com.Eme.pages;

import java.awt.Window;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Eme.helper.DataSlayer;
import com.Eme.helper.helper;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import freemarker.core.ReturnInstruction.Return;

public class HomePage extends BrowserManagement {

	LoginPage loginPage= new LoginPage();
	public HomePage() {
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

	@FindBy(xpath = "//li[@class=\"dropdown_menu\"]")
	WebElement menuElement;

	@FindBy(xpath = "//div[@class=\"product-grid\"]/descendant::li")
	WebElement searchresult;

	@FindBy(xpath = "//input[@id=\"searchbox\"]")
	WebElement searchboxElement;

	@FindBy(id = "sortby")
	WebElement sortby;

	@FindBy(xpath = "//li[@class=\"dropdown_menu\"]/child::a[@href=\"/eyeglasses/\"]")
	WebElement eyeglassmenu;

	@FindBy(xpath = "//li[@class=\"dropdown_menu\"]/child::a[@href=\"/sunglasses/\"]")
	WebElement sunglassmenu;

	@FindBy(xpath = "//div[@class=\"products-listing-container row\"]/child::div")
	WebElement elemetsElement;

	@FindBy(xpath = "//li[@id=\"sunglasses_menu\"]/child::a")
	WebElement sunglass;

	@FindBy(xpath = "//div[@class=\"buttons grid-btn\"]/child::button[@value=\"Buy Frame Only\"]")
	WebElement addframeonlycta;

	@FindBy(xpath = "//button[@id='S23C3688_0']")
	WebElement BuyNowCta;

	@FindBy(xpath = "//button[@id=\"btn-proceed-checkout\"]")
	WebElement proceedbtnElement;

	@FindBy(xpath = "//span[@class=\"prodId\"]")
	WebElement bredcrumbval;

	@FindBy(xpath = "//button[@class=\"close\"]/child::span")
	WebElement logincrossbtn;

	// Logo click test
	public boolean isLogoClickable() {
		boolean result = helper.clickElemenetTest(logo);
		return result;
	}

	public boolean helplink() {
		boolean result = helper.clickElemenetTest(helplink);
		return result;
	}

	public boolean cart() {
		boolean result = helper.clickElemenetTest(carticon);
		return result;
	}

	public boolean isCartEmpty() {
		int cartnum = Integer.parseInt(cartcount.getText());
		if (cartnum == 0) {
			cart();
			cartcounttext.isDisplayed();
			return true;
		} else {
			return false;
		}

	}

	public String getElementText() {
		if (menuElement.isDisplayed() && menuElement.isEnabled()) {
			List<WebElement> webElement = driver.findElements(By.xpath("//li[@class=\"dropdown_menu\"]"));
			String menueleString = "";
			for (WebElement ele : webElement) {
				menueleString += ele.getText() + ",";
			}
			return menueleString;
		}

		return null;
	}

	public int countOfSearchResult() {
		if (searchboxElement.isDisplayed()) {
			searchboxElement.sendKeys(DataSlayer.getData(0, 0, 0));
			searchboxElement.sendKeys(Keys.ENTER);
			List<WebElement> prodcount = driver
					.findElements(By.xpath(("//div[@class=\"products-listing-container row\"]/child::div")));
			int count = prodcount.size();
			return count;
		}

		return 0;
	}

	public String getSortvalues() {
		if (searchboxElement.isDisplayed()) {
			searchboxElement.sendKeys("eyeglass");
			searchboxElement.sendKeys(Keys.ENTER);
			List<WebElement> prodcount = driver.findElements(By.id("sortby"));
			String sortvalues = "";
			for (WebElement sortval : prodcount) {
				sortvalues += sortval.getText() + ",";
			}
			return sortvalues;
		}

		return null;
	}

	// common method to add product to cart
	public void addProdTocart(WebElement webelement, WebElement menuelement) {
		if (menuelement.isDisplayed() && menuelement.isEnabled()) {
			try {
				webelement.click();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			helper.waitfornextAction(driver, 5000);
			List<WebElement> elementlist = driver.findElements(By.xpath("//div[@class=\"owl-item active\"]/descendant::a/child::img"));
			for (WebElement element : elementlist) {
				helper.waitfornextAction(driver, 3000);
				try {
					helper.waitForClick(driver, element, 3000);
				} catch (StaleElementReferenceException e) {
					System.out.println(e);
				}
			}
		} else {
			System.out.println("No Element found");
		}
	}

	public void addEyeGlass() {
		try {
			addProdTocart(eyeglassmenu, menuElement);
			helper.waitForClick(driver, addframeonlycta, 3000);
			helper.waitfornextAction(driver, 3000);
			proceedbtnElement.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addSunGlass() {
		try {
			addProdTocart(sunglassmenu, menuElement);
			helper.waitForClick(driver, BuyNowCta, 3000);
			helper.waitfornextAction(driver, 3000);
			helper.waitForClick(driver, proceedbtnElement, 3000);
			helper.waitfornextAction(driver, 3000);
			loginPage.loginByPass("shailendra.k@eyemyeye.com", "test@123");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
