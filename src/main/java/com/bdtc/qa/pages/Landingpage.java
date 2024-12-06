package com.bdtc.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.bdtc.qa.base.Basepage;

public class Landingpage extends Basepage {

	// Page elements
	@FindBy(xpath = "//a[@class ='nav-link dropdown-toggle' and contains(text(),'Login')]")
	WebElement loginMenu;

	@FindBy(id = "EmailId")
	WebElement emailId;

	@FindBy(id = "Password")
	WebElement password;

	@FindBy(xpath = "//button[contains(text(),'Login')]")
	WebElement submitBtn;

	public Landingpage(WebDriver driver, ExtentTest test) throws IOException {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}

	public void openLoginMenu() throws IOException {
		test.log(Status.INFO, "Clicking on the login menu");
		// captureScreenshots(driver, test); // Capture screenshot for logging
		loginMenu.click();
	}

	public void enterCredentials(String email, String passwordValue) throws IOException {
		test.log(Status.INFO, "Entering email and password");
		emailId.sendKeys(email);
		password.sendKeys(passwordValue);
		// captureScreenshots(driver, test); // Capture screenshot after entering
		
	}

	public Homepage clickLoginButton() throws IOException {
		test.log(Status.INFO, "Clicking the login button");
		// captureScreenshots(driver, test); // Capture screenshot before submitting
		submitBtn.click();
		return new Homepage(driver,test);
	}

	public boolean isUserLoggedIn(String username) {
		return driver.getPageSource().contains(username);
	}
}
