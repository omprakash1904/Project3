package com.prakash.automation.businessscripts;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import bsh.commands.dir;

public class window {
	WebDriver d = new ChromeDriver();
	
	d.get("https://www.bing.com");
	Thread.sleep(2000);
	d.findElement(By.linkText("MSN")).click();
    System.out.println("clicked on msn");
    d.findElement(By.linkText("Office Online")).click();
    System.out.println("clicked on office online");
    WebElement outlook = d.findElement(By.linkText("Outlook.com"));
    outlook.click();
    System.out.println("clicked on outlook.com");
    
   // String currentWindow =d.getWindowHandle();
    Set<String> windows = d.getWindowHandles();
    System.out.println("windows size");
    List<String> list = new ArrayList<String>(windows);
    d.switchTo().window(list.get(3));
    System.out.println("switched to outlook.com windw");
    WebElement createaccount = d.findElement(By.xpath("//a[@class='linkButton']"));
    createaccount.click();
    System.out.println("operation performed on 3rd window is outlook.com:" +createaccount);
   
    d.switchTo().window(list.get(0));
    System.out.println("switched to bing.com");
    d.findElement(By.xpath("//input[@id='sb_form_q']")).sendKeys("java");
    
    d.switchTo().window(list.get(1));
    System.out.println("switched to msn window");
    WebElement search = d.findElement(By.xpath("//input[@id='q']"));
    search.clear();
    //search.sendKeys("selenium by ramesh anapati");
    Actions a = new Actions(d);
    a.sendKeys(search,"selenium by ramesh anapati");
    a.build().perform();
    
    WebElement websearch = d.findElement(By.xpath("//button[@title='web search']"));
    websearch.click();
    
}

}
