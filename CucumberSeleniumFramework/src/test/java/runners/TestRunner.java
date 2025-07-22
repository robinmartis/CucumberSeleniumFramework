package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/java/features",
    glue = {"stepdefinitions", "hooks"},
    plugin = {"pretty", 
    		"html:target/cucumber-reports.html", 
    		"json:target/cucumber.json", 
    		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"  // Add Extent adapter
    },
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
