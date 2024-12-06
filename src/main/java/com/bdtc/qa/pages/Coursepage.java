package com.bdtc.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.bdtc.qa.base.Basepage;

public class Coursepage extends Basepage {

	public Coursepage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
		
	}

  
	public Requiredcoursepage select_the_required_course(String course_name) {
		WebElement course = driver.findElement(By.xpath("//li/a[contains(text(),'" + course_name + "')]"));
		test.log(Status.INFO, "clicking on the "+ course_name +" course");
		
		course.click();
		 return new Requiredcoursepage(driver,test);
	}
	
	
   
}
