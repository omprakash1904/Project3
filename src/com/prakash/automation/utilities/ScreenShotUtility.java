package com.prakash.automation.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.prakash.automation.base.DriverEngine;

public class ScreenShotUtility extends DriverEngine {
public static String takeScreenshot(WebDriver driver,String img) throws IOException
{
	img=""+img+".jpeg";
	TakesScreenshot t=(TakesScreenshot)driver;
	File file=t.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(file, new File(img));
	return img;
	
}
}
