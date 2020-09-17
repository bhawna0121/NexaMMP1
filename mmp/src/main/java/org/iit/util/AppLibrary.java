package org.iit.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppLibrary {
	
	
	public static WebElement waitforElementClickable(WebDriver driver,long timeinSecs,By e)
	{
		WebDriverWait wait = new WebDriverWait(driver,timeinSecs);
		WebElement continueWE = wait.until(ExpectedConditions.elementToBeClickable(e));
		return continueWE;
		
	}

}
