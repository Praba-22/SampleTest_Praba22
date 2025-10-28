package com.project.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/resources/Features/Login.feature",
		glue = "com.project.stepDefinitions", // Step definition package
		
		plugin = { "pretty",
		        "html:target/CucumberReports/CucumberReport.html",
		        "json:target/CucumberReports/CucumberReport.json",
		        "rerun:target/failed_scenarios.txt" }, tags = "@smoke", // Run specific tagged scenarios
		        
		dryRun = false,
		monochrome = true, // Better console output
		publish = true // For online report (optional)
)
public class RunnerClass extends AbstractTestNGCucumberTests {
}
