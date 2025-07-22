package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jdk.internal.org.jline.utils.Log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.LoginPage;
import utils.LoggerHelper;

public class LoginSteps {
    LoginPage loginPage;
    private static final Logger log = LoggerHelper.getLogger(LoginSteps.class);

    @Given("I open the browser")
    public void i_open_the_browser() {
    	log.info("Starting the login step");
        loginPage = new LoginPage(Hooks.driver); 
    }

    @When("I navigate to {string}")
    public void i_navigate_to(String url) {
        Hooks.driver.get(url);
        log.info("Login page loaded");
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password) {
        loginPage.enterEmail(username);
        log.info("Username is entered" );
        loginPage.enterPassword(password);
        log.info("Password is engtered");
    }

    @Then("I should see the login button")
    public void i_should_see_the_login_button() {
        boolean visible = loginPage.isLoginButtonDisplayed();
        System.out.println("Login button visible: " + visible);
        log.info("Login button is visible");
    }
}
