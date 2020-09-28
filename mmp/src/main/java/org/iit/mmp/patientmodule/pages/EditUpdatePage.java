package org.iit.mmp.patientmodule.pages;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;
import org.iit.util.BaseClass;
import org.iit.util.Logger;
import org.iit.mmp.helper.HelperClass;
import org.iit.util.AppLibrary;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditUpdatePage {
	
	WebDriver driver;
	HelperClass helperObj;
	Random rand = new Random();
	String actual = "Your Profile has been updated.";
	String expected;
	WebElement we;
	
	//Store Expected Values
	HashMap<String,String> hMap1  = new HashMap<String,String>();
	//Store Actual Values
	HashMap<String,String> hMap2  = new HashMap<String,String>();
	
	By userNameTB = By.id("username");
	By passwordTB = By.id("password");
	By submitBtn = By.name("submit");
	By editButtonID = By.id("Ebtn");
	By firstNameTB = By.id("fname");
	By lastNameTB = By.id("lname");
	By licenseTB = By.id("licn");
	By SSNTB = By.id("ssn");
	By addressTB = By.id("addr");
	By ageID = By.id("age");
	By weightID = By.id("weight");
	By heightTB = By.id("height");
	By cityTB = By.id("city");
	By stateTB = By.id("state");
	By zipCodeTB = By.id("zip");
	By providerInfoTB = By.id("proinfo");
	By insuranceInfoTB = By.id("Insinfo");
	By saveButtonID = By.id("Sbtn");

	
	public  HashMap<String, String> editAllFields() throws IOException
	{
		editAgeField();
		editWeightField();
		editHeightField();
		editFirstNameField();
		editLastNameField();
		editLicenseField();
		editSSNField();
		editAddressField();
		editCityField();
		editStateField();
		editZipCodeField();
		editProviderInfoField();
		editInsuranceInfoField();
		Logger.logKV("I", hMap1);
		return hMap1;
	}
	
	public EditUpdatePage(WebDriver driver)
	{
		this.driver = driver;
		System.out.println("In Constructor");
		helperObj = new HelperClass(driver);
		hMap1 = new HashMap <String, String> ();
		hMap2 = new HashMap <String, String> ();
		rand = new Random();
	}
	
	public void editAgeField(){

		we = driver.findElement(ageID);
		helperObj.highLightElement(we);
		String ageValue = 18+rand.nextInt(82)+"";//18 and older only can login
		we.clear();
		we.sendKeys(ageValue);
		hMap1.put("Age", ageValue);
	}

	public void editWeightField(){

		we = driver.findElement(weightID);
		helperObj.highLightElement(we);
		String weightValue = 20+rand.nextInt(200)+"";//metric or US Standard? 
		we.clear();
		we.sendKeys(weightValue);
		hMap1.put("Weight", weightValue);
	}
	
	public void editHeightField(){
		we = driver.findElement(heightTB);
		helperObj.highLightElement(we);
		String heightValue = 30+rand.nextInt(200)+"";//metric or US standard?
		hMap1.put("Height", heightValue);
		we.clear();
		we.sendKeys(heightValue);
		
	}
	
	public void editFirstNameField(){
		we = driver.findElement(firstNameTB);
		helperObj.highLightElement(we);
		String firstNameValue = "QAEditFirstName"+(char)(65+rand.nextInt(26));
		hMap1.put("FName", firstNameValue);
		we.clear();
		we.sendKeys(firstNameValue);
	}
	public void editLastNameField(){

		we = driver.findElement(lastNameTB);
		helperObj.highLightElement(we);
		String lastNameValue = "QAEditLastName"+(char)(65+rand.nextInt(26));
		hMap1.put("LName", lastNameValue);
		we.clear();
		we.sendKeys(lastNameValue);
	}
	public void editLicenseField() throws IOException{
		we = driver.findElement(licenseTB);
		helperObj.highLightElement(we);
		//String licenseValue = Calendar.getInstance().getTimeInMillis()%100000000+"";
		String licenseValue = "12345678";
		hMap1.put("License", licenseValue);
		we.clear();
		we.sendKeys(licenseValue);
		
	}
	public void editSSNField(){
		we = driver.findElement(SSNTB);
		helperObj.highLightElement(we);
		String ssnValue = Calendar.getInstance().getTimeInMillis()%1000000000+"";
		hMap1.put("SSN", ssnValue);
		we.clear();
		we.sendKeys(ssnValue);
	}
	public void editAddressField(){
		we = driver.findElement(addressTB);
		helperObj.highLightElement(we);
		String addressValue = 1+rand.nextInt(999)+", QAEditAddress";
		hMap1.put("Address", addressValue);
		we.clear();
		we.sendKeys(addressValue);
	}
	public void editCityField(){
		int noOfChars = 7;
		we = driver.findElement(cityTB);
		helperObj.highLightElement(we);
		String cityValue = AppLibrary.getRandomString(noOfChars);
		hMap1.put("City", cityValue);
		we.clear();
		we.sendKeys(cityValue);
	}
	public void editStateField() throws IOException{

		we = driver.findElement(stateTB);
		helperObj.highLightElement(we);
		String stateValue = AppLibrary.getRandomState();
		stateValue = stateValue.replaceAll("\\s", "");
		hMap1.put("State", stateValue);
		we.clear();
		we.sendKeys(stateValue);
	}
	
	public void editZipCodeField(){
		int noOfDigits = 5;
		we = driver.findElement(zipCodeTB);
		helperObj.highLightElement(we);
		String zipCodeValue =  AppLibrary.getRandomNoOfDigits(noOfDigits)+"";
		hMap1.put("ZipCode", zipCodeValue);
		we.clear();
		we.sendKeys(zipCodeValue);
		
	}
	public void editProviderInfoField(){

		int noOfChars = 6;
		we = driver.findElement(providerInfoTB);
		helperObj.highLightElement(we);
		//String providerInfoValue = AppLibrary.getRandomString(noOfChars);
		String providerInfoValue = "";
		hMap1.put("Providerinfo", providerInfoValue);
		we.clear();
		we.sendKeys(providerInfoValue);
	}
	public void editInsuranceInfoField(){

		int noOfChars = 10;
		we = driver.findElement(insuranceInfoTB);
		helperObj.highLightElement(we);
	//	String providerInsuranceInfoValue = AppLibrary.getRandomString(noOfChars);
		String providerInsuranceInfoValue = "";
		hMap1.put("InsuranceInfo", providerInsuranceInfoValue);
		we.clear();
		we.sendKeys(providerInsuranceInfoValue);
	}		
	
	public void clickOnEditButton()
	{    
		WebElement e = AppLibrary.waitforElementClickable(driver, 20, editButtonID);
		e.click();
	}
	public String clickOnSaveButton1() throws IOException{
		String msg="";
		try{
			helperObj.highLightElement(driver.findElement(saveButtonID));	
			driver.findElement(saveButtonID).click();
			Alert alert = driver.switchTo().alert();
			msg = alert.getText();
			alert.accept();
		}
		catch(Exception e){
			System.out.println("Exception got: "+e.getMessage());
		}
		return msg;

	}
	public String acceptAlert()
	{
		Alert alrt = driver.switchTo().alert();
		String msg = alrt.getText().trim();
		alrt.accept();
		return msg;
	}
	
	public HashMap <String, String> getAllFieldValues(){
		//clickEditButton();
		hMap2.put("FName", driver.findElement(firstNameTB).getAttribute("value"));
		hMap2.put("LName", driver.findElement(lastNameTB).getAttribute("value"));
		hMap2.put("License", driver.findElement(licenseTB).getAttribute("value"));
		hMap2.put("SSN", driver.findElement(SSNTB).getAttribute("value"));
		hMap2.put("Address", driver.findElement(addressTB).getAttribute("value"));
		hMap2.put("Age", driver.findElement(ageID).getAttribute("value"));
		hMap2.put("Weight", driver.findElement(weightID).getAttribute("value"));
		hMap2.put("Height", driver.findElement(heightTB).getAttribute("value"));
		hMap2.put("City", driver.findElement(cityTB).getAttribute("value"));
		hMap2.put("State", driver.findElement(stateTB).getAttribute("value"));
		hMap2.put("ZipCode", driver.findElement(zipCodeTB).getAttribute("value"));
		hMap2.put("Providerinfo", driver.findElement(providerInfoTB).getAttribute("value"));
		hMap2.put("InsuranceInfo", driver.findElement(insuranceInfoTB).getAttribute("value"));
		Logger.logKV("SecondHASPMAP", hMap2);
		return hMap2;
	}
	
	public void verifyAlerMessage() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		WebElement continueWE = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(saveButtonID)));
		driver.findElement(saveButtonID).click();
		Boolean message = false;
		Alert alert = driver.switchTo().alert();
		if (alert.getText().contains("Your Profile has been updated.")) {
			message = true;
			System.out.println("Patient data saved and alert message verified.");
			// Accepting alert
			alert.accept();
		} else {
			message = false;
			System.out.println("Patient data not updated sucessfully");
		}//verifyAlerMessage

	}
	
	public  HashMap<String, String> editRandomFields() throws IOException
	{
		System.out.println("editData");
		//choosing a random number to update that many number of fields
		int number = 1+rand.nextInt(13);
		System.out.println("We are going to update "+number+" fields");

		for(int i=1;i<=number;i++){
			//String field = dataFields[num]; This version of java takes only int in cases, not String types.
			int num = 1+rand.nextInt(13);
			System.out.println("editing the field no."+num );
			switch(num){
			case 1 :
				editFirstNameField();
				break;
			case 2 :
				editLastNameField();
				break;
			case 3 :
				editLicenseField();
				break;
			case 4 :
				editSSNField();
				break;
			case 5 :
				editAddressField();
				break;
			case 6 :
				editAgeField();
				break;
			case 7 :
				editWeightField();
				break;
			case 8 :
				editHeightField();
				break;
			case 9 :
				editCityField();
				break;
			case 10 :
				editStateField();
				break;
			case 11 :
				editZipCodeField();
				break;
			case 12 :
				editProviderInfoField();
				break;
			case 13 :
				editInsuranceInfoField();
				break;
			}	
		}
		return hMap1;	
	}
	
	
}
