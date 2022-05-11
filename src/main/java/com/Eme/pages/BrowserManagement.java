package com.Eme.pages;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserManagement {

	public static WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports reports;
	public static ExtentTest test;
	
	@BeforeSuite
	public void reportConfig() {
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"./Reports/Finalreport.html");
		htmlReporter.config().setDocumentTitle("EyemyEye Web Test Report");
		htmlReporter.config().setReportName("EME Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);
	}
	
	//browser activity method
	@SuppressWarnings("deprecation")
	@BeforeMethod
	public static void launchBrowser() {
		
		if (System.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (System.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (System.getProperty("browser").equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		} else if (System.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("No associated webdriver found..");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		//driver.get("https://www.eyemyeye.com/");
		driver.get(System.getProperty("url"));
	}

	//Quit browser
	@AfterMethod(alwaysRun = true)
	public static void closeBrowser(ITestResult result)throws IOException {
		if (result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL,MarkupHelper.createLabel(result.getName()+"-Test Case Failed-",ExtentColor.RED));
			test.log(Status.FAIL,MarkupHelper.createLabel(result.getThrowable()+"-Test Case Failed-",ExtentColor.RED));
		}else if (result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP,MarkupHelper.createLabel(result.getName()+"-Test Case Skipped-",ExtentColor.BROWN));
		}else if (result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS,MarkupHelper.createLabel(result.getName()+"-Test Case Passed-",ExtentColor.GREEN));
		}
		
		if (driver!=null) {
			driver.quit();
		}
			
	       // driver=null;
	}
	
	@AfterSuite
	public void reportClean() {
		reports.flush();
	}
	
}
