package com.project.Runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
	    features = "Automation_SampleCodes/src/test/resources/Features",
	    glue = {"com.project.stepDefinitions", "com.project.hooks"},
	    plugin = {
	        "pretty",
	        "html:target/CucumberReports/CucumberReport.html",
	        "json:target/CucumberReports/CucumberReport.json",
	        "rerun:target/failed_scenarios.txt"
	    },
	    monochrome =true,
	    dryRun =false,
	    tags ="@smoke"
	)

public class RunnerClass extends AbstractTestNGCucumberTests {
}
