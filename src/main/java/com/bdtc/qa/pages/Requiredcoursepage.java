package com.bdtc.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.bdtc.qa.base.Basepage;

public class Requiredcoursepage extends Basepage {
	
	@FindBy(xpath = "//button[contains(text(),'Enroll Now')]")
	WebElement enrollNowBtn;

	public Requiredcoursepage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}

	public void click_enrollNow_btn() {
		test.log(Status.INFO, "After navigating to threquired course click on the EnrollNow button");
		enrollNowBtn.click();
		test.log(Status.INFO, "Redirected to Payment page");
		if (driver.getTitle().equalsIgnoreCase("Payment")) {
			System.out.println("Successfully navigated to payment page");
		}
	}

}
