package Eggtimer.Eggtimer;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		 features = "src/test/java/Eggtimer/Eggtimer/Features",
		 glue = "Eggtimer.Eggtimer.stepDefinition",
		 monochrome = true,
		 plugin = {"json:target/jsonReports/cucumber-json-report.json" }
		 )

		 
public class CukeRunner {

}
