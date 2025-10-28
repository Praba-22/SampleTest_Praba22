package com.project.hooks;

import com.Project.base.BaseClass;

//import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class HooksClass extends BaseClass {

	@Before
	public void setup(Scenario scenario) {
		// Setup Extent Report
		setupExtentReports("Login_Report");
		createTest(scenario.getName());

		// Launch Browser (you can also read from config)
		launchBrowser("chrome", "https://www.saucedemo.com/");
		test.info("Browser Launched and Navigated to URL");
	}
	
//	@BeforeStep
//    public void beforeStep(Scenario scenario) {
//        String stepName = scenario.getName();
//        test.info("STEP STARTED ➜ " + stepName);
//    }
	
//	@After
//	public void tearDown(Scenario scenario) {
//		if (scenario.isFailed()) {
//			test.fail("Scenario Failed: " + scenario.getName());
//		} else {
//			test.pass("Scenario Passed: " + scenario.getName());
//		}
//		
//		flushReports();
//		closeBrowser();
//	}
}
