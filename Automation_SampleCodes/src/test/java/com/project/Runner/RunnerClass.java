package com.project.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import com.Project.base.*;

@CucumberOptions(features = ".//src//test//resources//Features", // Path to your .feature files
		glue = "com.project.stepDefinitions", // Step definition package
		plugin = { "pretty", "html:target/CucumberReports/CucumberReport.html",
				"json:target/CucumberReports/CucumberReport.json",
				"rerun:target/failed_scenarios.txt" }, tags = "@smoke",// or @regression", // Run specific tagged scenarios
		monochrome = true, // Better console output
		publish = true // For online report (optional)
)
public class RunnerClass extends AbstractTestNGCucumberTests {
}
