package com.project.hooks;

import com.Project.base.BaseClass;

import io.cucumber.java.After;
//import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HooksClass extends BaseClass {

	@Before
	public void setup(Scenario scenario) {
		try {
			// Initialize Extent Reports and create test
			setupExtentReports("Login_Report");
			createTest(scenario.getName());

			// Launch browser with notifications blocked
			launchBrowser("chrome", "https://www.saucedemo.com/");
			test.info("Browser launched and navigated to URL successfully.");

			// Handle Chrome notifications (if any residual popups)
			try {
				Notifications();
			} catch (Exception e) {
				test.info("No browser notifications detected at launch.");
			}

		} catch (Exception e) {
			test.fail("Browser setup failed: " + e.getMessage());
		}
	}

	@After
	public void tearDown(Scenario scenario) {
		try {
			if (scenario.isFailed()) {
				takeScreenshot("FailedScenario_" + scenario.getName());
				test.fail("Scenario failed: " + scenario.getName());
			} else {
				test.pass("Scenario passed: " + scenario.getName());
			}

			flushReports(); // Save and close Extent Report
		} catch (Exception e) {
			System.out.println("Error while closing report: " + e.getMessage());
		} finally {
			if (driver != null) {
				driver.quit(); // Always quit the browser
			}
		}
	}
}
