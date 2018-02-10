package com.prakash.automation.businessscripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Neee {
	public static void main(String[] args) throws InterruptedException {
		
	    WebDriver driver = new FirefoxDriver();
	    driver.get("http://www.google.com/");
	    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	    System.out.println(driver.getTitle());
	    String gooleHome=driver.getWindowHandle();
	    Actions act = new Actions(driver);
	    act.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).perform();
	   /* driver.get("https://www.gmail.com");*/
	    act.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
	    driver.get("http://www.bing.com/");
	    System.out.println(driver.getTitle());
	    act.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
	    Thread.sleep(5000);
	    driver.get("http://www.gmail.com/");
	    System.out.println(driver.getTitle());
	    Set<String> windows=driver.getWindowHandles();
	    System.out.println(windows);
	    List<String> list=new ArrayList<String>(windows);
	    System.out.println(list);
	    driver.switchTo().window(list.get(0));
	}

}
