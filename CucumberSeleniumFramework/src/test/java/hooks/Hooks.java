package hooks;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.Status;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import utils.ExtentReportManager;
import utils.StepTracker;
import java.io.ByteArrayInputStream;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setUp(Scenario scenario) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 
        
     // Create a test in Extent report
        ExtentReportManager.setTest(
            ExtentReportManager.getReporter().createTest(scenario.getName())
        );
    }
    
    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {  // Capture only failed steps
        	String stepName = scenario.getName().replaceAll("[^a-zA-Z0-9]", "_");
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failed Step: " + stepName);
            
         // Attach to Allure
            Allure.addAttachment("Screenshot - " + stepName, new ByteArrayInputStream(screenshot));

            // Log to Extent Reports
            ExtentReportManager.getTest().log(Status.FAIL, "Failed at step: " + StepTracker.currentStep)
                               .addScreenCaptureFromBase64String(
                                   ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64),
                                   "Screenshot - " + stepName
                               );
        }else {
            // Log successful step in Extent Report
            ExtentReportManager.getTest().log(Status.PASS, "Step passed: " + StepTracker.currentStep);
        }
    }


//    private int stepCounter = 0;
//    
//    @BeforeStep
//    public void beforeStep(Scenario scenario) {
//        stepCounter++;
//        // capture BEFORE state
//        byte[] png = ScreenshotUtil.capture(Hooks.driver, scenario.getName(), "step" + stepCounter + "_before");
//        scenario.attach(png, "image/png", "Before Step " + stepCounter);
//    }
    
    
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        ExtentReportManager.getReporter().flush();
    }
}
