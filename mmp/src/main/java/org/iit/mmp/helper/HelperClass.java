package org.iit.mmp.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperClass {
	
	WebDriver driver;
	public HelperClass(WebDriver driver)
	{
		this.driver= driver;    
	
	
	}
	public void login(String uname,String pword,String url)
	{
		launchBrowser(url);
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pword);
		driver.findElement(By.name("submit")).click();
	}
	public void navigateToAModule(String moduleName)
	{
		driver.findElement(By.xpath("//span[contains(text(),'"+moduleName+"')]")).click();
	}
	public void launchBrowser(String url)
	{
		driver.get(url);
		 
	}

}
