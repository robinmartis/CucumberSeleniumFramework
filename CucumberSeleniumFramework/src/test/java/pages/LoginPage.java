package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    By email = By.id("email");
    By password = By.id("pass");
    By loginButton = By.name("login");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String username) {
        driver.findElement(email).sendKeys(username);
    }

    public void enterPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    public boolean isLoginButtonDisplayed() {
        return driver.findElement(loginButton).isDisplayed();
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
    
    By createAccountButton = By.linkText("Create new account");
    By forgotPasswordLink = By.linkText("Forgotten password?");

    public void clickCreateAccount() {
        driver.findElement(createAccountButton).click();
    }

    public void clickForgotPassword() {
        driver.findElement(forgotPasswordLink).click();
    }
    
    public String LinkCreateAPage() {
    	return driver.findElement(By.linkText("Create a Page")).getText();
    }

    
    
}
