package org.iit.mmp.adminmodule.pages;

import org.iit.util.AppLibrary;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class UsersPage {
	WebDriver driver;
	By officeLoginLink = By.linkText("Office Login");
	By adminLoginButtonXpath = By.xpath("(//a[.='Login'])[2]");
	By usernameID = By.id("username");
	// By usernameID =By.xpath("//input[@id='username']");
	By passwordID = By.id("password");
	By signInButtonName = By.name("admin");
	String findingpatientBySSNName = "//table/tbody/tr/td[contains(.,'%ssn%')]/preceding-sibling::td/a[contains(.,'%name%')]";
	String adminModules = "//span[contains(.,'%module%')]";
	By statusID = By.id("sapproval");
	By submitButtonXpath = By.xpath("//input[@value='Submit']");

	public UsersPage(WebDriver driver) {
		this.driver = driver;

	}
	// Method to navigate to different Admin module

	public boolean navigateToAdminModule(String module) {
		String adminModulesXpath = adminModules.replace("%module%", module);
		driver.findElement(By.xpath(adminModulesXpath)).click();

		return true;

	}

	// Method to login into admin module . In this we are not passing url.

	public boolean adminLogin(String uName, String pwd) throws InterruptedException {
		WebElement e = AppLibrary.waitforElementClickable(driver, 30, adminLoginButtonXpath);
		e.click();
		Thread.sleep(10000);
		driver.findElement(usernameID).sendKeys(uName);
		driver.findElement(passwordID).sendKeys(pwd);
		driver.findElement(signInButtonName).click();
		return true;

	}

	// Method - Finding Patient by Name and SSN on Admin User page
	public boolean findPatient(String name, String ssn) {
		String findingpatientBySSNXapth = findingpatientBySSNName.replace("%ssn%", ssn);
		String findingpatientBySSNNameXapth = findingpatientBySSNXapth.replace("%name%", name);
		driver.findElement(By.xpath(findingpatientBySSNNameXapth)).click();
		return true;

	}

	// Method- Changing Patient Status by admin on Personal Details Page of
	// Admin Module
	public boolean patientStatusChange(String pStatus) {
		Select selectStatus = new Select(driver.findElement(statusID));
		selectStatus.selectByVisibleText(pStatus);
		return true;

	}

	// Clicking on Submit button by admin on Personal Details Page of Admin
	// Module.
	public boolean submitButton() throws InterruptedException {

		// java script to scrolling down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,3100)");
		// js.executeScript("arguments[0].scrollIntoView();",
		// driver.findElement(submitButtonXpath);
		Thread.sleep(10000);
		WebElement s = AppLibrary.waitforElementClickable(driver, 30, submitButtonXpath);
		s.click();
		return true;

	}

	// Method - To verify Patient (Registration)Status update.
	public boolean acceptedAlertVerification() {
		Alert alert = driver.switchTo().alert();
		String actualMsg = alert.getText();
		String expectedMsg = "USER has been updated.";
		Assert.assertEquals(actualMsg.trim(), expectedMsg.trim());
		alert.accept();
		return true;
	}

	// public boolean rejectedAlertVerification(){
	// Alert alert = driver.switchTo().alert();
	// String actualMsg = alert.getText();
	// System.out.println(actualMsg);
	// alert.accept();
	// return true;
	// }
	//

}
