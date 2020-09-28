package org.iit.mmp.adminmodule.tests;
import java.util.HashMap;
import org.iit.mmp.adminmodule.pages.MessageSendingPage;
import org.iit.mmp.helper.HelperClass;
import org.iit.util.BaseClass;
import org.iit.util.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MessageSendingDocTests extends BaseClass{

	/**
	 * Static declarations
	 **/
	private static String appURL;
	private static String adminURL; 
	private static String username;
	private static String password;
	private static String adminUsername;
	private static String adminPassword;
	private static String subject = "Hello Dr. Becky";
	private static String message = "Hello Doc, Please Refill my blood sugar prescriptions";
	MessageSendingPage messagePage;
	
	By sendButton = By.xpath("//input[contains(@value,'Send')]");
	By subjectBox = By.id("subject");
	By messageBox = By.id("message");
	
	String linkSendingMessage = "Messages";
	String linkEditProfile = "Profile";
	String linkLogout = "Logout";
	By linkSendingMessageAdminM = By.xpath("//a[contains(@href,'message')]");
	HelperClass  patientDriver;
	HelperClass adminDriver;
	HashMap<String, String> messageData = new HashMap<String, String>();
	
	
	@Test
	public void sendMessageAndValidateFromAdmin() throws Exception {
		instantiateDriver();
		//Instantiate  Driver and open Patient URL and Login into Patient Module	
		patientDriver = new HelperClass(driver);
		appURL=pro.getProperty("URL");
		username = pro.getProperty("patientUser");
		password = pro.getProperty("patientPassword");
		patientDriver.launchBrowser(appURL);
		patientDriver.login(username, password);
	
		// -- get patient profile name for later use
		
		patientDriver.navigateToAModule(linkEditProfile);
		String patientFirstName = driver.findElement(By.id("fname")).getAttribute("value");
		// -- send message as a Patient 
		messagePage= new MessageSendingPage(driver);
		patientDriver.navigateToAModule(linkSendingMessage);
		messageData = messagePage.sendMessage(patientFirstName, subject.trim(), message.trim());
		Logger.log("I", "Done! Message sent as Patient");
		
		// -- Logout from Patient Module
		patientDriver.navigateToAModule(linkLogout);
		
		//Instantiate  Driver and open ADMIN URL and Login into ADMIN Module	
		adminURL = pro.getProperty("urlAdmin");
		adminDriver = new HelperClass(driver);
		adminDriver.launchBrowser(adminURL);
		adminUsername = pro.getProperty("adminUser");
		adminPassword = pro.getProperty("adminPassword");
		adminDriver.adminLogin(adminUsername, adminPassword);
		Thread.sleep(3000);
		adminDriver.navigateToAModule(linkSendingMessage);
		// -- retrieve message and validate
		
		Assert.assertEquals(messagePage.validateMessage(messageData), true);
		Logger.log("I", "Message Validated from ADMIN Module");			
		// -- Logout from Admin Module
		adminDriver.navigateToAModule(linkLogout);
		Logger.log("I", "Logged out as ADMIN");		
		
	} // sendMessageAndValidateFromAdmin
		
}//MessageSendingDocTests
