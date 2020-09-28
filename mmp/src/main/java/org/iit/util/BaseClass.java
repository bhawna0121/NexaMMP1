package org.iit.util;

import java.lang.module.Configuration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.iit.mmp.config.ProjectConfig;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.IHookCallBack;
import org.testng.ITestResult;

public class BaseClass {
	
	protected  WebDriver driver;
	protected  Properties pro;
	 	
		public void instantiateDriver() throws Exception
		{
			System.out.println("First line of the instantiate method");
			ProjectConfig pConf = new ProjectConfig();
			pro = pConf.loadProperites();
			String browser = pro.getProperty("browser");
			if(browser.equalsIgnoreCase("chrome")){
				System.out.println("Inside if");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			else if (browser.equalsIgnoreCase("firefox")){	
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			}
			driver.manage().window().maximize();
			System.out.println("LastLine of the instatiate method of TestBase");
		}

}
