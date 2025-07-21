package stepdefinitions;

import hooks.Hooks;
import pages.LoginPage;
import pages.ResetPasswordPage;
import io.cucumber.java.en.*;
import io.cucumber.messages.types.Hook;

public class PasswordResetSteps {
    LoginPage loginPage = new LoginPage(Hooks.driver);
    ResetPasswordPage resetpassword = new ResetPasswordPage(Hooks.driver); 
    

    @Then("I should see the {string} page")
    public void i_should_see_the_page(String pageTitle) {
//        String actualTitle = Hooks.driver.getTitle();
        
        String actualTitle = resetpassword.getHeaderText();
        
        System.out.println("Pop up Title: " + actualTitle);
        if (!actualTitle.contains(pageTitle)) {
            throw new AssertionError("Expected: " + pageTitle + " but got: " + actualTitle);
        }
    }
}
