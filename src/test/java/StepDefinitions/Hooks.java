package stepDefinitions;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.bdtc.qa.base.Basepage;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends Basepage {
	
	  WebDriver driver;

	    @Before
	    public void setup() throws IOException {
	    	test = reports.createTest("Validating the Login Functionality");
			driver = initializationAndOpenApplication(prop.getProperty("browser"));
	      
	        test.log(Status.INFO, "Browser initialized and application opened.");
	    }

	    @After
	    public void teardown() throws IOException {
	        if (driver != null) {
	            driver.quit(); // Quit the browser
	            test.log(Status.INFO, "Browser closed.");
	        }
	        if (reports != null) {
	            reports.flush(); // Flush ExtentReports
	        	Desktop.getDesktop().browse(new File(path).toURI());

	        }

}
}