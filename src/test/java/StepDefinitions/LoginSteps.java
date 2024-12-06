package StepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.bdtc.qa.base.Basepage;
import com.bdtc.qa.pages.Landingpage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends Basepage {

	Landingpage landingpage;

	@Given("user to open the application")
	public void user_to_open_the_application() throws IOException {

		landingpage = new Landingpage(driver, test); // Initialize Landingpage
	}

	@Given("Click on the Login menu")
	public void click_on_the_login_menu() throws IOException {
		landingpage.openLoginMenu(); // Call method from Landingpage
	}

	@When("user provides valid email and password")
	public void user_provides_valid_email_and_password() throws IOException {
		landingpage.enterCredentials(prop.getProperty("email"), prop.getProperty("password")); // Provide credentials
	}

	@When("click on the login button")
	public void click_on_the_login_button() throws IOException {
		/*
		 * landingpage.clickLoginButton(); // Call method from Landingpage
		 * 
		 * try { // Check for successful login String profile_name =
		 * driver.findElement(By.xpath("//span[contains(text(),'maheswari')]")).getText(
		 * ); String expectedProfileName = "Uma maheswari";
		 * 
		 * Assert.assertEquals(profile_name, expectedProfileName,
		 * "Profile name does not match!");
		 * System.out.println("User logged in successfully"); } catch
		 * (NoSuchElementException e) { // Handle login failure try { Alert errorAlert =
		 * driver.switchTo().alert(); String actualErrorMessage = errorAlert.getText();
		 * String expectedErrorMessage =
		 * "Invalid EmailId or password! Please try again.";
		 * 
		 * Assert.assertEquals(actualErrorMessage, expectedErrorMessage,
		 * "Unexpected error message!");
		 * System.out.println("User failed to log in due to invalid credentials."); }
		 * catch (NoAlertPresentException ex) {
		 * System.err.println("Login failed, but no alert was present."); } }
		 */
	}

	@Then("user should navigate to login page")
	public void user_should_navigate_to_login_page() {
		boolean isLoggedIn = landingpage.isUserLoggedIn("Uma Maheswari");
		if (isLoggedIn) {
			test.log(Status.PASS, "User successfully logged in and navigated to the home page.");
		} else {
			test.log(Status.FAIL, "User login failed. Home page not displayed.");
		}

	}

	@When("user provides following details")
	public void user_provides_following_details(DataTable dataTable) {
		List<List<String>> datalist = dataTable.asLists(String.class);

		for (List<String> row : datalist) {
			// Assuming the first column is email and the second is password
			String email = row.get(0);
			String password = row.get(1);

			try {
				landingpage.enterCredentials(email, password);
				
				landingpage.clickLoginButton(); // Call method from Landingpage

				 try {
				        // Check for successful login
				        String profile_name = driver.findElement(By.xpath("//span[contains(text(),'maheswari')]")).getText();
				        String expectedProfileName = "Uma maheswari";

				        Assert.assertEquals(profile_name, expectedProfileName, "Profile name does not match!");
				        System.out.println("User logged in successfully");
				    } catch (NoSuchElementException e) {
				        // Handle login failure
				        try {
				            Alert errorAlert = driver.switchTo().alert();
				            String actualErrorMessage = errorAlert.getText();
				            String expectedErrorMessage = "Invalid EmailId or password! Please try again.";

				            Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Unexpected error message!");
				            System.out.println("User failed to log in due to invalid credentials.");
				        } catch (NoAlertPresentException ex) {
				            System.err.println("Login failed, but no alert was present.");
				        }
				    }

			} catch (IOException e) {
				System.err.println("Error entering credentials for email: " + email);
				e.printStackTrace();
			}
		}
	}
}
