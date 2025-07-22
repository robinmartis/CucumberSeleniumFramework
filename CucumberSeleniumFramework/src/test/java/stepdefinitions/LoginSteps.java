package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.LoginPage;

public class LoginSteps {
    LoginPage loginPage;

    @Given("I open the browser")
    public void i_open_the_browser() {
//    	Log.info("Starting the login step");
        loginPage = new LoginPage(Hooks.driver); 
    }

    @When("I navigate to {string}")
    public void i_navigate_to(String url) {
        Hooks.driver.get(url);
//        Log.info("Login page loaded");
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password) {
        loginPage.enterEmail(username);
//        Log.info("Username is entered" );
        loginPage.enterPassword(password);
//        Log.info("Password is engtered");
    }

    @Then("I should see the login button")
    public void i_should_see_the_login_button() {
        boolean visible = loginPage.isLoginButtonDisplayed();
        System.out.println("Login button visible: " + visible);
//        Log.info("Login button is visible");
    }
}
