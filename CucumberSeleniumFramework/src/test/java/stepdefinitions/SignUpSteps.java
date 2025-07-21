package stepdefinitions;

import hooks.Hooks;
import pages.LoginPage;
import pages.SignUpPage;
import io.cucumber.java.en.*;

public class SignUpSteps {
    LoginPage loginPage = new LoginPage(Hooks.driver);
    SignUpPage signUpPage;

    @When("I click on {string}")
    public void i_click_on(String link) {
        if (link.equals("Create new account")) {
            loginPage.clickCreateAccount();
        } else if (link.equals("Forgotten password?")) {
            loginPage.clickForgotPassword();
        }
    }

    @When("I enter first name {string} and last name {string}")
    public void i_enter_first_name_and_last_name(String first, String last) {
        signUpPage = new SignUpPage(Hooks.driver);
        signUpPage.enterFirstName(first);
        signUpPage.enterLastName(last);
    }

    @When("I enter mobile number {string}")
    public void i_enter_mobile_number(String mobile) {
        signUpPage.enterMobileNumber(mobile);
    }

    @When("I enter new password {string}")
    public void i_enter_new_password(String pwd) {
        signUpPage.enterPassword(pwd);
    }

    @Then("I should see the Sign Up button")
    public void i_should_see_the_sign_up_button() {
        boolean visible = signUpPage.isSignUpButtonDisplayed();
        System.out.println("Sign Up button visible: " + visible);
    }
}
