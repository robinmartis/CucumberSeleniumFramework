package stepdefinitions;

import org.apache.logging.log4j.Logger;

import hooks.Hooks;
import pages.LoginPage;
import pages.ResetPasswordPage;
import utils.LoggerHelper;
import utils.ScreenshotUtil;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.cucumber.messages.types.Hook;

public class PasswordResetSteps {
    LoginPage loginPage = new LoginPage(Hooks.driver);
    ResetPasswordPage resetpassword = new ResetPasswordPage(Hooks.driver); 
    private static final Logger log = LoggerHelper.getLogger(PasswordResetSteps.class);
    
    @Then("I should see the {string} page")
    public void i_should_see_the_page(String pageTitle) {
        
        String actualTitle = resetpassword.getHeaderText();
        log.info("In the password Reset page"); 
        
        System.out.println("Pop up Title: " + actualTitle);
        log.info("Actual text is : " +actualTitle);
        if (!actualTitle.contains(pageTitle)) {
            throw new AssertionError("Expected: " + pageTitle + " but got: " + actualTitle);
        }
    }
}
