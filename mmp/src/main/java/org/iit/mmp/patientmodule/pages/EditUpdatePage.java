package org.iit.mmp.patientmodule.pages;

import java.util.HashMap;
import java.util.Random;

import org.iit.util.AppLibrary;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditUpdatePage {
	
	WebDriver driver;
	By ageID= By.id("age");
	By editButtonID = By.id("Ebtn");
	By saveButtonID = By.id("Sbtn");
	By weightID = By.id("weight");
	
	
	
	Random rand = new Random();
	//Store Expected Values
	HashMap<String,String> hMap1  = new HashMap<String,String>();
	//Store Actual Values
	HashMap<String,String> hMap2  = new HashMap<String,String>();
	
	public EditUpdatePage(WebDriver driver)
	{
		this.driver = driver;
		System.out.println("In Constructor");
	}
	public void editAgeField()
	{
		String randomAge = 10 + rand.nextInt(80) +"";
		hMap1.put("AGE",randomAge);
		WebElement e = driver.findElement(ageID);
		e.clear();
		e.sendKeys(randomAge);
	}
	public void editWeightField()
	{
		String randomAge = 10 + rand.nextInt(80) +"";
		hMap1.put("WEIGHT",randomAge);
		WebElement e = driver.findElement(weightID);
		e.clear();
		e.sendKeys(randomAge);
	}
	public void clickOnEditButton()
	{    
		WebElement e = AppLibrary.waitforElementClickable(driver, 20, editButtonID);
		e.click();
	}
	public void clickOnSaveButton()
	{
		driver.findElement(saveButtonID).click();
	}
	public String acceptAlert()
	{
		Alert alrt = driver.switchTo().alert();
		String msg = alrt.getText();
		alrt.accept();
		return msg;
	}
	public  HashMap<String, String> editAllFields()
	{
		editAgeField();
		editWeightField();
		return hMap1;
	
	}
	public  HashMap<String, String> getAllFieldValues()
	{
		hMap2.put("AGE", driver.findElement(ageID).getAttribute("value"));
		hMap2.put("WEIGHT", driver.findElement(weightID).getAttribute("value"));
		return hMap2;
	}

	
}
