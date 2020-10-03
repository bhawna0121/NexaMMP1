package org.iit.mmp.helper;
import org.iit.util.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class HelperClass {
	
	WebDriver driver;
	public HelperClass(WebDriver driver){
		this.driver = driver;
	}
	
//	private By loginMainLink = By.linkText("Login");
	private By loginMainLink= By.xpath("//input[@type='submit']");
	private By loginUsername = By.id("username");
	private By loginPassword = By.id("password");
	private By AdminloginUsername = By.xpath("//input[@id='username']");
	private By AdminloginPassword = By.xpath("//input[@id='password']");
	
	By loginClick = By.xpath("//input[@name='submit']");
	By AdminloginClick = By.xpath("//input[@name='admin']");
	By logoutLink = By.xpath("/html/body/div[1]/div[1]/div[1]/div/ul/li[9]/a/span");
	By editProfileLink = By.xpath("//a[@href='profile.php']");
	 
	
	public void login(String uname,String pword)
	{
		Logger.log("I", "Logged in as Patient");;
		driver.findElement(loginUsername).sendKeys(uname);
		driver.findElement(loginPassword).sendKeys(pword);
		driver.findElement(loginMainLink).click();
	}
	public void navigateToAModule(String moduleName)
	{
		driver.findElement(By.xpath("//span[contains(text(),'"+moduleName+"')]")).click();
	}
	
	public void launchBrowser(String url)
	{
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void adminLogin(String uname,String pword)
	{
		Logger.log("I", "Logged in as Admin");
		driver.findElement(AdminloginUsername).sendKeys(uname);
		driver.findElement(AdminloginPassword).sendKeys(pword);
		driver.findElement(AdminloginClick).click();
	}
	
	public void logoutPatientPortal() {
		System.out.println("Attempting to logout from PATIENT Portal");
		driver.findElement(logoutLink).click();
		driver.quit();
	} // logoutPatientPortal
	
	public void logoutAdminPortal() {
		System.out.println("Attempting to logout from ADMIN Portal");
		driver.findElement(logoutLink).click();
		driver.quit();
	} // logoutPatientPortal
	
	public void highLightElement(WebElement ele){
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:2px solid red;')", ele);
	}
	

}
