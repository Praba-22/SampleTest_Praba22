//package test;
//
//public class Test2 {
//
//}
//package com.Project.pages;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//public class AccountCreation_PO {
//
//	WebDriver driver;
//
//	@FindBy(xpath = "//a[contains(text(),'Create')]")
//	WebElement Create_Acc;
//
//	@FindBy(xpath = "//input[@id='user[first_name]'")
//	WebElement FirstName;
//
//	@FindBy(xpath = "//input[@id='user[last_name]']")
//	WebElement LastName;
//
//	@FindBy(xpath = "//input[@id='user[email]']")
//	WebElement Email;
//
//	@FindBy(xpath = "//input[@id='user[password]']")
//	WebElement Pswd;
//
//	@FindBy(xpath = "//button[@type='submit']")
//	WebElement Signup;
//
//	public AccountCreation_PO(WebDriver driver) {
//		this.driver = driver;
//		PageFactory.initElements(driver, this); // initialize elements
//	}
//
//	public void Create_Acc() {
//		Create_Acc.click();
//	}
//
//	public void FirstName(String fname) {
//		FirstName.sendKeys(fname);
//	}
//
//	public void LastName(String lname) {
//		LastName.sendKeys(lname);
//	}
//
//	public void Email(String email) {
//		Email.sendKeys(email);
//	}
//
//	public void Pswd(String pswd) {
//		Pswd.sendKeys(pswd);
//	}
//
//	public void Signup() {
//		Signup.click();
//	}
//
//}
