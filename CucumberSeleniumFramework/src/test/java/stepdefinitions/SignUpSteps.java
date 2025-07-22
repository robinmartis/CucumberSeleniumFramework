package stepdefinitions;

import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.ExtentTest;

import hooks.Hooks;
import pages.LoginPage;
import pages.SignUpPage;
import utils.ExtentReportManager;
import utils.LoggerHelper;
import utils.ScreenshotUtil;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;

public class SignUpSteps {
    LoginPage loginPage = new LoginPage(Hooks.driver);
    SignUpPage signUpPage;
    
    private static final Logger log = LoggerHelper.getLogger(SignUpSteps.class);
//    ExtentTest test = ExtentReportManager.getTest();

    @When("I click on {string}")
    public void i_click_on(String link) {
        if (link.equals("Create new account")) {
            loginPage.clickCreateAccount();
            log.info("Clicked on Create new Account");
        } else if (link.equals("Forgotten password?")) {
            loginPage.clickForgotPassword();
            log.info("Clicked on Forgot Password");
        }
    }

    @When("I enter first name {string} and last name {string}")
    public void i_enter_first_name_and_last_name(String first, String last) {
        signUpPage = new SignUpPage(Hooks.driver);
        signUpPage.enterFirstName(first);
        signUpPage.enterLastName(last);
        log.info("Entered first name and last name ");
    }

    @When("I enter mobile number {string}")
    public void i_enter_mobile_number(String mobile) {
        signUpPage.enterMobileNumber(mobile);
        log.info("Mobile no is entered");
    }

    @When("I enter new password {string}")
    public void i_enter_new_password(String pwd) {
        signUpPage.enterPassword(pwd);
        log.info("Password is entered ");
    }

    @Then("I should see the Sign Up button")
    public void i_should_see_the_sign_up_button() {
        boolean visible = signUpPage.isSignUpButtonDisplayed();
        System.out.println("Sign Up button visible: " + visible);
        log.info("Sign up button visible : " +visible);
    }
}
