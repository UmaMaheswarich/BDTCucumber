package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "D:\\Javaworks\\BDTCucumber\\src\\test\\resources\\Features\\login.feature"
		//features = "D:\\Javaworks\\BDTCucumber\\src\\test\\resources\\Features\\course.feature"
		,glue = {"StepDefinitions"}
		,plugin = {"pretty" ,"html:target/HTMLReports/reports.html",
				"json:target/JsonReports/reports.json",
				"junit:target/JUnitReports/reports.xml"
				
				}
				
		)


public class TestRunner {

}
