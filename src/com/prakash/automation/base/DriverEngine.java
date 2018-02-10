package com.prakash.automation.base;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.prakash.automation.utilities.ScreenShotUtility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DriverEngine<T extends WebDriver>{
private static WebDriver driver;
private static ExtentReports er;
private static ExtentTest et;
@Parameters({"browser"})
@BeforeSuite
private static void openBrowser(String browser)
{
	if(browser.equalsIgnoreCase("firefox"))
	{
		System.setProperty("webdriver.geckodriver.driver", "E:\\WebDrivers\\geckodriver.exe");
		driver=new FirefoxDriver();
		intit();
	}
	else if (browser.equalsIgnoreCase("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "E:\\webDrivers\\chromedriver.exe");
		driver=new ChromeDriver();
		intit();
	}
	else if (browser.equalsIgnoreCase("ie")) 
	{
		System.setProperty("webdriver.ie.driver", "E:\\WebDrivers\\IEDriverServer.exe");
		driver=new InternetExplorerDriver();
		intit();
	}
	else if (browser.equalsIgnoreCase("opera")) 
	{
		System.setProperty("webdriver.opera.driver", "E:\\WebDrivers\\operadriver.exe");
		driver=new OperaDriver();
		intit();
	}
	else
	{
		System.out.println("pass proper parameter browser");
	}
}
public WebDriver getDriver()
{
	return driver;
}
public static void intit()
{
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();
}
@BeforeTest
public static void startTest()
{
	er=new ExtentReports("E:\\IMPORTANT\\tarun\\framework2\\ExtentReports\\reports.html");	
}
@BeforeMethod
public static void beforeMethod(Method method)
{
	et=er.startTest(method.getName());
}
@AfterMethod
public static void afterMethod(ITestResult result) throws IOException
{
	if(result.getStatus()==ITestResult.FAILURE)
	{
		et.log(LogStatus.INFO, result.getThrowable());
		et.log(LogStatus.FAIL, "find the below ScreenShot"+et.addScreenCapture(ScreenShotUtility.takeScreenshot(driver, result.getName())));
	}
	er.flush();
	er.endTest(et);
}
@AfterTest
public void testCaseFailed()
{
	if(er!=null)
		er.close();		
}
@AfterSuite
public static void close()
{
	if(driver!=null)
	driver.close();
	else
		System.out.println("driver pointing to null");
}

}
