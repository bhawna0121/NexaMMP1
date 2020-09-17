package org.iit.patientmodule.tests;

import org.iit.util.BaseClass;
import org.testng.annotations.Test;

public class PatientRegistrationTests extends BaseClass{

	@Test
	public void validateRegistration()
	{
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		String title = driver.getTitle();
		System.out.println("Title" + title);
	}
	
	 
}
