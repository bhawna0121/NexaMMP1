package org.iit.mmp.adminmodule.pages;
import java.util.HashMap;

import org.iit.util.BaseClass;
import org.iit.util.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MessageSendingPage extends BaseClass{
	
	/*Variable Declarations*/
	WebDriver driver;
	By linkSendingMessagePatientM = By.xpath("//a[contains(@href,'sendmessage')]");
	By linkSendingMessageAdminM = By.xpath("//a[contains(@href,'message')]");
	By editProfileLink = By.xpath("//a[@href='profile.php']");
	By sendButton = By.xpath("//input[contains(@value,'Send')]");
	By subjectBox = By.id("subject");
	By messageBox = By.id("message");
	By patientName = By.xpath("//table[@class='table']//tr[2]//td[1]");
	By subjectMessage = By.xpath("//table[@class='table']//tr[2]//td[2]");
	By descriptionMessage = By.xpath("//table[@class='table']//tr[3]//td[2]");

	public MessageSendingPage(WebDriver driver){
		this.driver = driver;
	}
	public HashMap<String, String> sendMessage(String patient, String subject, String message) throws InterruptedException {
		HashMap<String, String> messageData = new HashMap<String, String>();	
		messageData.put("Subject", subject);
		messageData.put("Message", message);
		messageData.put("Name", patient);
		driver.findElement(subjectBox).sendKeys(messageData.get("Subject"));
		driver.findElement(messageBox).sendKeys(messageData.get("Message"));
		Logger.log("I", "Data from sendMessage");
		Logger.logKV("I", messageData);
		driver.findElement(sendButton).click();
		//Alert alert = driver.switchTo().alert();
		String actualMsg;
		try {
		Alert alert = driver.switchTo().alert();
		actualMsg = alert.getText();
		alert.accept();
		} catch(Exception e){
		System.out.println("Alert Not Present : "+e.getMessage());
		}
		return messageData;
	} // sendMessage
	
	public HashMap<String, String> retrieveRecentMessage() {
		String name, subject, description;
		name = driver.findElement(patientName).getText();
		subject = driver.findElement(subjectMessage).getText();
		description = driver.findElement(descriptionMessage).getText();
		HashMap<String, String> postedMessage = new HashMap<String, String>();
		postedMessage.put("Subject", subject);
		postedMessage.put("Message", description);
		postedMessage.put("Name", name);
		Logger.log("I", "Data from retrieveRecentMessage");
		Logger.logKV("I", postedMessage);
		return postedMessage;
	} // retrieveRecentMessage
	
	public boolean validateMessage(HashMap<String, String> messageData) {
		boolean result = false;
		HashMap<String, String> postedMessage = retrieveRecentMessage();
		Logger.log("I", postedMessage.get("Subject") + " = " + messageData.get("Subject"));
		Logger.log("I", postedMessage.get("Message") + " = " + messageData.get("Message"));
		Logger.log("I", postedMessage.get("Name") + " = " + messageData.get("Name"));
		if (postedMessage.get("Subject").equals(messageData.get("Subject"))
				&& postedMessage.get("Message").equals(messageData.get("Message"))
				&& postedMessage.get("Name").equals(messageData.get("Name"))) {
			result = true;
		}
		return result;
	}
}//MessageSendingPage
