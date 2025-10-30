package com.project.stepDefinitions;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import com.Project.base.*;
import io.cucumber.java.en.*;
import com.Project.pages.*;

public class LoginSteps extends BaseClass {
    LoginPage_PO login_page;
    Alert alert;

    // ✅ Step 1: Open browser and verify login page
    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        try {
            // Launch browser and navigate to URL
            launchBrowser("chrome", "https://www.saucedemo.com/");

            // Initialize page object AFTER browser launch
            login_page = new LoginPage_PO(driver);

            // Validate title
            String expectedTitle = "Swag Labs";
            String actualTitle = driver.getTitle(); // ❌ You used getPageSource() earlier (wrong)

            if (actualTitle.equalsIgnoreCase(expectedTitle)) {
                takeScreenshot("LoginPage");
                test.pass("User is on the login page.");
            } else {
                takeScreenshot("LoginPage_Failed");
                test.fail("Login page title mismatch! Expected: " + expectedTitle + " | Found: " + actualTitle);
                Assert.fail("Login page validation failed - Title mismatch.");
            }

        } catch (Exception e) {
            test.fail("Exception while verifying login page: " + e.getMessage());
            takeScreenshot("LoginPage_Failed");
            Assert.fail("Login page validation failed due to exception: " + e.getMessage());
        }
    }

    // ✅ Step 2: Enter credentials
    @When("User enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
        try {
            waitForElementVisible(login_page.text_username, 10);
            Thread.sleep(500);
            login_page.enterusername(username);

            waitForElementVisible(login_page.text_password, 10);
            Thread.sleep(500);
            login_page.enterpassword(password);

            test.pass("User entered username and password successfully.");
            takeScreenshot("EnterCredentials_Passed");

        } catch (Exception e) {
            test.fail("Failed to enter credentials: " + e.getMessage());
            takeScreenshot("EnterCredentials_Failed");
            Assert.fail("Credentials entry failed.");
        }
    }

    // ✅ Step 3: Click login
    @When("User clicks on the login button")
    public void user_clicks_on_the_login_button() {
        try {
            waitForElementClickable(login_page.login_btn, 10);
            login_page.click_login();
            test.pass("User clicks on the login button.");

            // Handle Chrome popups (password save / notifications)
            try {
                Notifications();
            } catch (Exception ne) {
                test.info("No browser popup appeared after login.");
            }

        } catch (Exception e) {
            test.fail("Login button click failed: " + e.getMessage());
            takeScreenshot("LoginClick_Failed");
            Assert.fail("Login button not clicked.");
        }
    }

    // ✅ Step 4: Validate homepage
    @Then("User should be redirected to the homepage")
    public void user_should_be_redirected_to_the_homepage() {
        try {
            String expectedText = "Produ"; // visible on the homepage
            String actualPageSource = driver.getPageSource();

            if (actualPageSource.contains(expectedText)) {
                takeScreenshot("ProductsPage");
                test.pass("User successfully redirected to the homepage.");
            } else {
                takeScreenshot("ProductsPage_Failed");
                test.fail("User not redirected to the homepage. Expected text not found.");
                Assert.fail("Homepage validation failed - Expected text not found.");
            }

        } catch (Exception e) {
            takeScreenshot("ProductsPage_Exception");
            test.fail("Exception occurred while verifying homepage: " + e.getMessage());
            Assert.fail("Homepage validation failed due to exception: " + e.getMessage());
        } 
        
        
        finally {
            flushReports();
            driver.quit();
        }
    }
}
