package hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ScreenshotUtil;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 
    }
    
//    @AfterStep
//    public void afterEachStep(Scenario scenario) {
//    	
//    	String stepLabel = String.valueOf(System.nanoTime()); // unique per step
//        byte[] png = ScreenshotUtil.capture(driver, scenario.getName(), stepLabel);
//        if (png.length > 0) {
//            scenario.attach(png, "image/png", "Step Screenshot");
//        }
//    	
//    }

    private int stepCounter = 0;
    
    @BeforeStep
    public void beforeStep(Scenario scenario) {
        stepCounter++;
        // capture BEFORE state
        byte[] png = ScreenshotUtil.capture(Hooks.driver, scenario.getName(), "step" + stepCounter + "_before");
        scenario.attach(png, "image/png", "Before Step " + stepCounter);
    }
    
    
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
