package com.project.stepDefinitions;
import com.Project.base.*;
import io.cucumber.java.en.*;

public class LoginSteps extends BaseClass{
	@Given("User is on the login page")
	public void user_is_on_the_login_page() {
	   launchBrowser("chrome", "https://courses.ultimateqa.com/users/sign_in");
	    test.pass("User is on the Login Page");
	  
	}

	@When("User enters username {string} and password {string}")
	public void user_enters_username_and_password(String string, String string2) {
	    
	}

	@When("User clicks on the login button")
	public void user_clicks_on_the_login_button() {
	   
	}

	@Then("User should be redirected to the homepage")
	public void user_should_be_redirected_to_the_homepage() {
	    
	}

	@Then("User should see an error message {string}")
	public void user_should_see_an_error_message(String string) {
	    
	}
}
