package org.iit.patientmodule.tests;

import java.util.HashMap;
import org.iit.mmp.helper.HelperClass;
import org.iit.mmp.patientmodule.pages.EditUpdatePage;
import org.iit.util.BaseClass;
import org.iit.util.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class EditUpdateTests extends BaseClass{
	
	/**
	 * Static declarations
	 **/
	private static String appURL;
	private static String adminURL; // 
	private static String username;
	private static String password;
	String linkEditProfile = "Profile";
	String actual = "Your Profile has been updated.";
	String expected;
	String linkLogout = "Logout";
	boolean resultAll;
	boolean resultSelected;
	SoftAssert sa;
	
	@Test
	public void validateEditFunctionality() throws Exception
	{
		SoftAssert sa = new SoftAssert();
		//Instantiate  Driver and open Patient URL and Login into Patient Module	
		instantiateDriver();
		HelperClass helperObj = new HelperClass(driver);
		helperObj = new HelperClass(driver);
		appURL=pro.getProperty("URL");
		username = pro.getProperty("patientUser");
		password = pro.getProperty("patientPassword");
		helperObj.launchBrowser(appURL);
		helperObj.login(username, password);
		
		 EditUpdatePage editPage = new EditUpdatePage(driver);
		 //Move to Profile EDIT Page in PAtient Portal
		 helperObj.navigateToAModule("Profile");
		 //Click on EDIT Button
		 editPage.clickOnEditButton();
		 //Call method for Editing Values
		 HashMap<String,String> hmap1 = editPage.editAllFields();
		 //CLick on SAVE Button & Compare Alert Message
		 String actual = editPage.clickOnSaveButton1().trim();
		 String expected = "Your Profile has been updated.";
		 Logger.log("Actual Alert", actual);
		 Logger.log("Expected Alert", expected);
		 Thread.sleep(3000);
		 sa.assertEquals(actual, expected);
		 //Compare both HASPMAP Values
		 HashMap<String,String> hmap2 =editPage.getAllFieldValues();
		 sa.assertEquals(hmap1, hmap2);
		 helperObj.logoutPatientPortal();
		 sa.assertAll();
	}//validateEditFunctionality
	
	@Test
	public void validateRandomEditFunctionality() throws Exception
	{
		SoftAssert sa = new SoftAssert();
		//Instantiate  Driver and open Patient URL and Login into Patient Module	
		instantiateDriver();
		HelperClass helperObj = new HelperClass(driver);
		helperObj = new HelperClass(driver);
		appURL=pro.getProperty("URL");
		username = pro.getProperty("patientUser");
		password = pro.getProperty("patientPassword");
		helperObj.launchBrowser(appURL);
		helperObj.login(username, password);
		
		 EditUpdatePage editPage = new EditUpdatePage(driver);
		 //Move to Profile EDIT Page in PAtient Portal
		 helperObj.navigateToAModule("Profile");
		 //Click on EDIT Button
		 editPage.clickOnEditButton();
		 //Call method for Editing Values
		 HashMap<String,String> hmap1 = editPage.editRandomFields();
		 //CLick on SAVE Button
		 //CLick on SAVE Button & Compare Alert Message
		 String actual = editPage.clickOnSaveButton1().trim();
		 String expected = "Your Profile has been updated.";
		 Logger.log("Actual Alert", actual);
		 Logger.log("Expected Alert", expected);
		 Thread.sleep(3000);
		 sa.assertEquals(actual, expected);
		 //Compare both HASPMAP Values
		 HashMap<String,String> hmap2 =editPage.getAllFieldValues();
		 //sa.assertEquals(hmap1, hmap2);
		 helperObj.logoutPatientPortal();
		 sa.assertAll();
	}
}
