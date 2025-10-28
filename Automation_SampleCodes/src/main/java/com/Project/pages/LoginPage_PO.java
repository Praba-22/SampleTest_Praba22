package com.Project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_PO {

	WebDriver driver;

	// --- Locators using XPath ---
	@FindBy(xpath = "//input[@id='user-name']")
	public WebElement text_username;

	@FindBy(xpath = "//input[@id='password']")
	public WebElement text_password;

	@FindBy(xpath = "//input[@id='login-button']")
	public WebElement login_btn;

	// --- Constructor ---
	public LoginPage_PO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // initialize elements
	}

	public void enterusername(String username) {
		text_username.clear();
		text_username.sendKeys(username);
	}

	public void enterpassword(String password) {
		text_password.clear();
		text_password.sendKeys(password);
	}

	public void click_login() {
		login_btn.click();
	}
}
