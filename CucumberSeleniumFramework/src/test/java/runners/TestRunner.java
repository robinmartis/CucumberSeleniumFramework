package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/java/features",
    glue = {"stepdefinitions", "hooks"},
    plugin = {"pretty", 
    		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", // Allure plugin
    		"html:target/cucumber-reports.html", 
    		"json:target/cucumber.json", 
    		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
    		"utils.StepTracker", // Register our custom event listener
    		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"  // Add Extent adapter
    },
    monochrome = false, 
    dryRun = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
