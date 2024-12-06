package StepDefinitions;

import java.io.IOException;

import org.testng.Assert;
import org.testng.asserts.Assertion;

import com.bdtc.qa.base.Basepage;
import com.bdtc.qa.pages.Coursepage;
import com.bdtc.qa.pages.Homepage;
import com.bdtc.qa.pages.Landingpage;
import com.bdtc.qa.pages.Requiredcoursepage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CourseSteps extends Basepage {

	public Homepage hp;
	public Coursepage cp;
	public Requiredcoursepage rcp;

	@Given("user is already on login page")
	public void user_is_already_on_login_page() throws IOException {
		Landingpage lp = new Landingpage(driver, test);
		lp.openLoginMenu();
		lp.enterCredentials(prop.getProperty("email"), prop.getProperty("password"));
		hp = lp.clickLoginButton();
	}

	@When("user click on the course menu")
	public void user_click_on_the_course_menu() {
		cp = hp.clickCourseMenu();
	}

	@Then("^user should able to select the required \"([^\\\"]*)\"$")
	public void user_should_able_to_select_the_required(String coursename) {

		rcp = cp.select_the_required_course(coursename);
	}

	@Then("^user should navigate to the particular course \"([^\\\\\\\"]*)\"$")
	public void user_should_navigate_to_the_particular_course(String expected_url) {

		String actual_url = driver.getCurrentUrl();
		Assert.assertEquals(actual_url, expected_url);

	}

	@And("user should try to enroll the course")
	public void user_should_try_to_enroll_the_course() {
		rcp.click_enrollNow_btn();

	}

}
