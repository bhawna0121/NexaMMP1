package org.iit.adminmodule.tests;
import org.iit.mmp.adminmodule.pages.UsersPage;
import org.iit.mmp.patientmodule.pages.LoginPage;
import org.iit.mmp.patientmodule.pages.RegisterPage;
import org.iit.util.BaseClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class RegisterVerification extends BaseClass{
	    // Open application
		// Click on Register Button 
		//Register New Patient by providing random data and Save
		// Verify Registration is successful.We will be landed on Home page.
		// Click Office Login and Login Button to get Admin Login Window
		// Login into Admin Module .UN - Thomas_444 ,Pwd - Edisison_444
		// Click on User Tab of Admin Module
		// Select Patient by searching patient by patient name and ssn.And click on selected patient
		// Change Status to accepted
		// Click on Submit button
		// Click on Alert Box and verify message "User has been updated.
		// Login into Patient Module with new patient credentials(un,pwd).
		// Verify new patient  could login,by verifying text which will be new patient username, which will be displyed on patient home page once patient logs in.

		//Test - For Accepted Status
		@Parameters({ "url", "adminUsername", "adminPwd", "adminModule", "patientRegStatus" })
		@Test(description="Changing Stataus to Accepted")
		public void acceptedRegistrationVerification(String url, String adminUsername, String adminPwd, String adminModule,
				String patientRegStatus) throws InterruptedException {

			SoftAssert sa = new SoftAssert();
			RegisterPage newPatient = new RegisterPage(driver);
			UsersPage patientStatus = new UsersPage(driver);
			LoginPage pLogin = new LoginPage(driver);

			// Open Application and click on RegisterButton
			boolean result = newPatient.navigateToRegisterpage(url);
			sa.assertTrue(result);

			// enter data on Register page and this method will return patient ssn ,Name, username,pwd
			String pData = newPatient.newPatientInfo();
			System.out.println(pData);

			// Getting each data by spliting and using arrays
			String patientSSN = pData.split(":")[0];
			String patientName = pData.split(":")[1];
			String patientUserName = pData.split(":")[2];
			String patientPwd = pData.split(":")[3];

			// click on save button on Register page
			boolean resultS = newPatient.SaveButton();
			sa.assertTrue(resultS);

			// Verify rEgisteration of new patient is successful
			boolean result1 = newPatient.registerationVerification();
			sa.assertTrue(result1);

			// logging into admin module
			boolean result2 = patientStatus.adminLogin(adminUsername, adminPwd);
			sa.assertTrue(result2);

			// navigate to Users tab of admin module
			boolean result3 = patientStatus.navigateToAdminModule(adminModule);
			sa.assertTrue(result3);

			// Select new patient by name and SSN
			boolean result4 = patientStatus.findPatient(patientName, patientSSN);
			sa.assertTrue(result4);

			// Changing Status to Accepted
			boolean result5 = patientStatus.patientStatusChange(patientRegStatus);
			sa.assertTrue(result5);

			// Clicking on Submit button to save
			boolean result6 = patientStatus.submitButton();
			sa.assertTrue(result6);

			// Verify status is updated and click Ok
			boolean result7 = patientStatus.acceptedAlertVerification();
			sa.assertTrue(result7);

			// Verify New Patient could login successfully and verify Text on Patient login page
			boolean result8 = pLogin.patientStatusApprovedLoginVerification(url, patientUserName, patientPwd);
			sa.assertTrue(result8);
			sa.assertAll();

		}
		
		//Test for Rejected Status
		@Parameters({ "url", "adminUsername", "adminPwd", "adminModule", "patientRegStatus" })
		@Test(description="Changing status to Rejected")  
	        public void rejectedRegistrationVerification(String url, String adminUsername, String adminPwd, String adminModule,
	    			String patientRegStatus)throws InterruptedException {
			SoftAssert sa = new SoftAssert();
			RegisterPage newPatient = new RegisterPage(driver);
			UsersPage patientStatus = new UsersPage(driver);
			LoginPage pLogin = new LoginPage(driver);

			// Open Application and click on RegisterButton
			boolean result = newPatient.navigateToRegisterpage(url);
			sa.assertTrue(result);

			// enter data on Register page and this method will return patient ssn ,Name, username,pwd
			String pData = newPatient.newPatientInfo();
			System.out.println(pData);

			// Getting each data by spliting and using arrays
			String patientSSN = pData.split(":")[0];
			String patientName = pData.split(":")[1];
			String patientUserName = pData.split(":")[2];
			String patientPwd = pData.split(":")[3];

			// click on save button on Register page
			boolean resultS = newPatient.SaveButton();
			sa.assertTrue(resultS);

			// Verify rEgisteration of new patient is successful
			boolean result1 = newPatient.registerationVerification();
			sa.assertTrue(result1);

			// logging into admin module
			boolean result2 = patientStatus.adminLogin(adminUsername, adminPwd);
			sa.assertTrue(result2);

			// navigate to Users tab of admin module
			boolean result3 = patientStatus.navigateToAdminModule(adminModule);
			sa.assertTrue(result3);

			// Select new patient by name and SSN
			boolean result4 = patientStatus.findPatient(patientName, patientSSN);
			sa.assertTrue(result4);

			// Changing Status to Accepted
			boolean result5 = patientStatus.patientStatusChange(patientRegStatus);
			sa.assertTrue(result5);

			// Clicking on Submit button to save
			boolean result6 = patientStatus.submitButton();
			sa.assertTrue(result6);

			// Verify status is updated and click Ok
			boolean result7 = patientStatus.acceptedAlertVerification();
			sa.assertTrue(result7);
			
			//Verify new patient login and rejected message after login
			boolean result8 = pLogin.patientStatusRejectedLoginVerification(url, patientUserName, patientPwd);
			sa.assertTrue(result8);
			sa.assertAll();

	}
		
		//Method for Pending status
		
		@Parameters({ "url", "adminUsername", "adminPwd", "adminModule", "patientRegStatus" })
		@Test(description="Changing status to Pending")  
	        public void pendingRegistrationVerification(String url, String adminUsername, String adminPwd, String adminModule,
	    			String patientRegStatus)throws InterruptedException {
			SoftAssert sa = new SoftAssert();
			RegisterPage newPatient = new RegisterPage(driver);
			UsersPage patientStatus = new UsersPage(driver);
			LoginPage pLogin = new LoginPage(driver);

			// Open Application and click on RegisterButton
			boolean result = newPatient.navigateToRegisterpage(url);
			sa.assertTrue(result);

			// enter data on Register page and this method will return patient ssn ,Name, username,pwd
			String pData = newPatient.newPatientInfo();
			System.out.println(pData);

			// Getting each data by spliting and using arrays
			String patientSSN = pData.split(":")[0];
			String patientName = pData.split(":")[1];
			String patientUserName = pData.split(":")[2];
			String patientPwd = pData.split(":")[3];

			// click on save button on Register page
			boolean resultS = newPatient.SaveButton();
			sa.assertTrue(resultS);

			// Verify rEgisteration of new patient is successful
			boolean result1 = newPatient.registerationVerification();
			sa.assertTrue(result1);

			// logging into admin module
			boolean result2 = patientStatus.adminLogin(adminUsername, adminPwd);
			sa.assertTrue(result2);

			// navigate to Users tab of admin module
			boolean result3 = patientStatus.navigateToAdminModule(adminModule);
			sa.assertTrue(result3);

			// Select new patient by name and SSN
			boolean result4 = patientStatus.findPatient(patientName, patientSSN);
			sa.assertTrue(result4);

			// Changing Status to Accepted
			boolean result5 = patientStatus.patientStatusChange(patientRegStatus);
			sa.assertTrue(result5);

			// Clicking on Submit button to save
			boolean result6 = patientStatus.submitButton();
			sa.assertTrue(result6);

			// Verify status is updated and click Ok
			boolean result7 = patientStatus.acceptedAlertVerification();
			sa.assertTrue(result7);
			
			//Verify new Patient login and pending message after login
			boolean result8 = pLogin.patientStatusPendingLoginVerification(url, patientUserName, patientPwd);
			sa.assertTrue(result8);
			sa.assertAll();
			

	}

	}


		

