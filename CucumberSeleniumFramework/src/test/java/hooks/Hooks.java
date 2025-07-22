package hooks;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExtentReportManager;
import com.aventstack.extentreports.ExtentTest;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setUp(Scenario scenario) {
    	// Create ExtentTest for each scenario
        ExtentTest test = ExtentReportManager.getExtent().createTest(scenario.getName());
        ExtentReportManager.setTest(test);
    	
        // Start browser
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 
    }
    
    
    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {  // Capture only failed steps
        	String stepName = scenario.getName().replaceAll("[^a-zA-Z0-9]", "_");
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failed Step: " + stepName);
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
        ExtentReportManager.flush();
    }
}
