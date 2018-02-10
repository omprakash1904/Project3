package com.prakash.automation.businessscripts;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class New {
	public static void main(String[] args) {
		WebDriver d=new FirefoxDriver();
		d.get("https://www.gmail.com");
		Actions a=new Actions(d);
		a.sendKeys(Keys.CONTROL).keyDown(Keys.TAB).perform();
	}

}
