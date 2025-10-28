//package test;
//
//public class Test1 {
//	package com.project.stepDefinitions;
//
//	import org.openqa.selenium.WebDriver;
//	import org.testng.Assert;
//
//	import com.Project.base.BaseClass;
//	import com.Project.pages.AccountCreation_PO;
//
//	import io.cucumber.java.en.*;
//
//	public class Account_creation extends BaseClass {
//
//		AccountCreation_PO accountcreation;
//
//		@Given("User is on the registration page")
//		public void user_is_on_the_registration_page() {
//			accountcreation.Create_Acc();
//
//			String exp_url = "https://courses.ultimateqa.com/users/sign_up";
//			String act_url = driver.getCurrentUrl();
//			Assert.assertEquals(act_url, exp_url, "User is navigated to Account Creation page");
//			test.pass("Account create page is opend");
//
//		}
//
//		@When("User enters first name {string}")
//		public void user_enters_first_name(String firstname) {
//			accountcreation.FirstName(firstname);
//			test.pass("Firstname entered Successfully");
//		}
//
//		@When("User enters last name {string}")
//		public void user_enters_last_name(String lastname) {
//			accountcreation.LastName(lastname);
//			test.pass("Lastname entered Successfully");
//		}
//
//		@When("User enters email {string}")
//		public void user_enters_email(String email) {
//			accountcreation.Email(email);
//			test.pass("Email entered Successfully");
//		}
//
//		@When("User enters password {string}")
//		public void user_enters_password(String password) {
//			accountcreation.Pswd(password);
//			test.pass("Password entered Successfully");
//		}
//
//		@When("User clicks on the Create Account button")
//		public void user_clicks_on_the_create_account_button() {
//			accountcreation.Signup();
//			
//		}
//
//		@Then("A success message {string} should be displayed")
//		public void a_success_message_should_be_displayed(String string) {
//
//		}
//
//		@Then("User should be redirected to the login page")
//		public void user_should_be_redirected_to_the_login_page() {
//
//		}
//	}
//
//}
