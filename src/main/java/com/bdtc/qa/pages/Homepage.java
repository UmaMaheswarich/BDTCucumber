package com.bdtc.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.bdtc.qa.base.Basepage;

public class Homepage extends Basepage {
	
	@FindBy(xpath = "//li[@class='nav-item dropdown mega-dropdown']/a[contains(text(),'Courses')]")
	WebElement courseMenu;

	public Homepage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	public void clickmenus(String menu) {
		//generic method to click all menus
		WebElement menus = driver.findElement(By.xpath("//a[contains(text(),'"+menu+"')]"));
		menus.click();
		
		
		
	}
	
	public Coursepage clickCourseMenu() {
		test.log(Status.INFO, "clicking on the Course Menu");
		courseMenu.click();
		test.log(Status.INFO, "opened the Course menu");
		return new Coursepage(driver,test);
	}

}
