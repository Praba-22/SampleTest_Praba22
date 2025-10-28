package com.project.stepDefinitions;

import org.testng.Assert;

import com.Project.base.*;
import io.cucumber.java.en.*;
import com.Project.pages.*;

public class LoginSteps extends BaseClass {
	LoginPage_PO login_page;
	
	@Given("User is on the login page")
	public void user_is_on_the_login_page() {
		
		launchBrowser("chrome", "https://www.saucedemo.com/");
		String expect_Tittle = "Swag Labs";
		Assert.assertEquals(expect_Tittle, driver.getPageSource());
		test.pass("User is on the Login Page");

	}

	@When("User enters username {string} and password {string}")
	public void user_enters_username_and_password(String username, String password) {
		login_page.enterusername(username);
		login_page.enterusername(password);
	}

	@When("User clicks on the login button")
	public void user_clicks_on_the_login_button() {
		login_page.click_login();
	}

	@Then("User should be redirected to the homepage")
	public void user_should_be_redirected_to_the_homepage() {
		String expect_Tittle = "Products";
		String act_Title= driver.getPageSource();
		if (expect_Tittle.equals(act_Title)) {
			test.pass("Login Successfully");
		} else {
			test.fail("Login Failed");
		}
	}

	@Then("User should see an error message {string}")
	public void user_should_see_an_error_message(String string) {
		flushReports();
		closeBrowser();
	}
}
