package com.project.stepDefinitions;

import org.testng.Assert;
import com.Project.base.*;
import io.cucumber.java.en.*;
import com.Project.pages.*;

public class LoginSteps extends BaseClass {
	LoginPage_PO login_page;

	@Given("User is on the login page")
	public void user_is_on_the_login_page() throws InterruptedException {

		login_page = new LoginPage_PO(driver);
		Thread.sleep(3000);
		Assert.assertTrue(driver.getTitle().contains("Swag Labs"));
		Thread.sleep(3000);
		test.pass("User is on the login page");
		takeScreenshot("LoginPage");

	}

	@When("User enters username {string} and password {string}")
	public void user_enters_username_and_password(String username, String password) {

		waitForElementVisible(login_page.text_username, 5);
		login_page.enterusername(username);

		waitForElementVisible(login_page.text_password, 5);
		login_page.enterpassword(password);
		test.pass("User enters username & password");
	}

	@When("User clicks on the login button")
	public void user_clicks_on_the_login_button() {

		waitForElementClickable(login_page.login_btn, 5);
		login_page.click_login();
		test.pass("User clicks on the login button");

	}

	@Then("User should be redirected to the homepage")
	public void user_should_be_redirected_to_the_homepage() {
		try {
			String expectedText = "Products";
			String actualText = driver.getPageSource();

			if (actualText.contains(expectedText)) {
				test.pass("User successfully redirected to homepage.");
				takeScreenshot("ProductsPage");
			} else {
				test.fail("User not redirected to homepage. Expected text not found.");
			}

			// You can still use assert to fail the step officially in Cucumber
			// Assert.assertTrue(actualText.contains(expectedText));

		} catch (Exception e) {
			test.fail("Exception occurred: " + e.getMessage());
			takeScreenshot("HomepageValidationFailed");
			// Assert.fail("Test step failed due to exception: " + e.getMessage());

			}
		flushReports();
	}
}
