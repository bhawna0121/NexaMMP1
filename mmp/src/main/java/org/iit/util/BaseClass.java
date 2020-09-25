package org.iit.util;
import java.io.IOException;
import java.util.Properties;

import org.iit.config.ProjectConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseClass {
	 	protected WebDriver driver;
		protected Properties prop;
		String browser;
		
		//@BeforeTest
		public void instantiateDriver()
		{
			WebDriverManager.chromedriver().setup();
			//Launching the browser
			driver = new ChromeDriver();
		}
		
		//Added by RA
		public void instantiatingDriver() throws IOException {
			ProjectConfiguration pConfig = new ProjectConfiguration();
			prop = pConfig.loadProperties();
			browser = prop.getProperty("browser");
			if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
		}
		
		// @AfterClass - RA
		public void tearDriver() {
			driver.close();
		}
}
