package org.iit.patientmodule.tests;

import java.io.IOException;
import java.util.HashMap;

import org.iit.mmp.helper.HelperClass;
import org.iit.mmp.patientmodule.pages.ScheduleAppointmentPage;
import org.iit.util.BaseClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ScheduleAppointmentTests extends BaseClass {
	private HelperClass helperObject;
	private String doctorName = "Sophia Rich";
	private String urlPatient;
	private String patientName;
	private String patientPassword;

	@Test
	public void validateScheduleAppointment() throws InterruptedException, IOException {

		SoftAssert sa = new SoftAssert();
System.out.println("1");
		// TC1 - Open the Chrome Browser
		instantiatingDriver();
		System.out.println("2");
		// TC2 - Enter URL and login details
		helperObject = new HelperClass(driver);
		System.out.println("5");
		urlPatient = prop.getProperty("urlPatient");
		helperObject.launchBrowser(urlPatient);
		patientName = prop.getProperty("patientName");
		patientPassword = prop.getProperty("patientPassword");
		helperObject.login(patientName, patientPassword);

		// TC3 - Navigate to Schedule Appointment
		helperObject.navigateToAModule("Schedule Appointment");

		// TC4 - Navigate to HomePage
		ScheduleAppointmentPage schApptPage = new ScheduleAppointmentPage(driver);
		HashMap<String, String> makeApptMap = schApptPage.schAppointment(doctorName);
		helperObject.navigateToAModule("HOME");

		// TC5 - Validate the Schedule Appointment/Visit details on the Homepage
		boolean match = schApptPage.compareValuesOnHomePage(makeApptMap);
		sa.assertTrue(match);

		// TC6 - Validate the Schedule Appointment details on the Schedule Appointment
		// page
		helperObject.navigateToAModule("Schedule Appointment");
		match = schApptPage.compareValuesOnScheduleAppt(makeApptMap);
		sa.assertTrue(match);

		sa.assertAll();

		tearDriver();
	}
}
