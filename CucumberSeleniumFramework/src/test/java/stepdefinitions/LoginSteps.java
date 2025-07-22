package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps {
    LoginPage loginPage;

    @Given("I open the browser")
    public void i_open_the_browser() {
        loginPage = new LoginPage(Hooks.driver); 
    }

    @When("I navigate to {string}")
    public void i_navigate_to(String url) {
        Hooks.driver.get(url);
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password) {
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
    }

    @Then("I should see the login button")
    public void i_should_see_the_login_button() {
        boolean visible = loginPage.isLoginButtonDisplayed();
        System.out.println("Login button visible: " + visible);
    }
}
