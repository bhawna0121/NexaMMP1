package org.iit.patientmodule.tests;

import java.util.HashMap;

import org.iit.mmp.helper.HelperClass;
import org.iit.mmp.patientmodule.pages.ScheduleAppointmentPage;
import org.iit.util.BaseClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class ScheduleAppointmentTests extends BaseClass {
	
	@Test
	public void validateScheduleAppointment() throws InterruptedException
	{
		 
		 SoftAssert sa = new SoftAssert();
		 HelperClass helperObj = new HelperClass(driver);
		 helperObj.login("ria1", "Ria12345");
		 ScheduleAppointmentPage sPage = new ScheduleAppointmentPage(driver);
		 helperObj.navigateToAModule("Schedule Appointment");
		 HashMap<String,String> hMap = sPage.bookAppointment("Beth");
		 helperObj.navigateToAModule("HOME");
		 boolean result=sPage.validateAppointmentDetailsinHomePage(hMap);
		 sa.assertTrue(result);
		 helperObj.navigateToAModule("Schedule Appointment ");
		 result = sPage.validateAppointmentDetailsinSPage(hMap);
		 sa.assertTrue(result);
		 sa.assertAll();
	}
	 
	

}
