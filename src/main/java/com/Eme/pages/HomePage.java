package com.Eme.pages;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Eme.helper.DataSlayer;
import com.Eme.helper.helper;

public class HomePage extends BrowserManagement{

	
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
	
	@FindBy(xpath="//div[@class=\"product-grid\"]/descendant::li")
	WebElement searchresult;
	
	@FindBy(xpath = "//input[@id=\"searchbox\"]")
	WebElement searchboxElement;
	
	@FindBy(id = "sortby")
	WebElement sortby;
	
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
	
	public String getElementText() {
		if (menuElement.isDisplayed()&& menuElement.isEnabled()) {
			List<WebElement> webElement=driver.findElements(By.xpath("//li[@class=\"dropdown_menu\"]"));
			String menueleString = "";
			for(WebElement ele : webElement) {
			    menueleString+=ele.getText()+"," ;
			}
			return menueleString;
		}
		
		return null;
	}
	
	public int countOfSearchResult() {
	   if (searchboxElement.isDisplayed()) {
	           searchboxElement.sendKeys(DataSlayer.getData(0, 0, 0));
	           searchboxElement.sendKeys(Keys.ENTER);
	           List<WebElement> prodcount=driver.findElements(By.xpath(("//div[@class=\"products-listing-container row\"]/child::div")));
	           int count=prodcount.size();
	           return count;
	}
		
		return 0;
	}

	public String getSortvalues() {
		   if (searchboxElement.isDisplayed()) {
		           searchboxElement.sendKeys("eyeglass");
		           searchboxElement.sendKeys(Keys.ENTER);
		           List<WebElement> prodcount=driver.findElements(By.id("sortby"));
		           String sortvalues="";
		           for (WebElement sortval : prodcount) {
					sortvalues+=sortval.getText()+",";
				}
		        return sortvalues;
		}
			
			return null;
		}
}
