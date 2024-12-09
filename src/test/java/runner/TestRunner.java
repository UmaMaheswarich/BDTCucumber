package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\test\\resources\\Features"
		
		,glue = {"stepDefinitions"}
		,dryRun = false
		,plugin = {"pretty" ,"html:target/HTMLReports/reports.html",
				"json:target/JsonReports/reports.json",
				"junit:target/JUnitReports/reports.xml"
				
				}
				
		)


public class TestRunner {

}
