package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.util.Assert;

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
    
    @Then("I should see the Create a Page link")
    public void i_should_see_the_create_a_page_link() {
        String actual = loginPage.LinkCreateAPage(); 
        String expected = "Create a Page"; 
        org.testng.Assert.assertEquals(actual, expected);
    	
    }
    
    @When("I enter user credentials to login")
    public void i_enter_user_credentials_to_login(io.cucumber.datatable.DataTable dataTable) {
    	
    	List<List<String>>data = dataTable.asLists(); 
    	loginPage.enterEmail(data.get(0).get(0));
        log.info("Username is entered" );
        loginPage.enterPassword(data.get(0).get(1));
        log.info("Password is engtered");
    	
    }
    
    @When("I enter user credentials to login using datatable")
    public void i_enter_user_credentials_to_login_using_datatable(io.cucumber.datatable.DataTable dataTable) {
        
    	List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
    	
    	for(Map<String, String> row : data) {
            String username = row.get("Username");
            String password = row.get("Password");
    		
            loginPage.enterEmail(username);
            log.info("Username is entered" );
            loginPage.enterPassword(password);
            log.info("Password is engtered");
    	}
    		
    	
    }

    
    @Given("test background step1")
    public void test_background_step1() {
        System.out.println("Running background step1 ");
    }
    @When("test background_step2")
    public void test_background_step2() {
    	System.out.println("Running background step2 ");
    }

    
    
    
    
}
