package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    WebDriver driver;

    By firstName = By.name("firstname");
    By lastName = By.name("lastname");
    By mobileNumber = By.name("reg_email__");
    By password = By.name("reg_passwd__");
    By signUpButton = By.name("websubmit");

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstName(String fname) {
        driver.findElement(firstName).sendKeys(fname);
    }

    public void enterLastName(String lname) {
        driver.findElement(lastName).sendKeys(lname);
    }

    public void enterMobileNumber(String mobile) {
        driver.findElement(mobileNumber).sendKeys(mobile);
    }

    public void enterPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    public boolean isSignUpButtonDisplayed() {
        return driver.findElement(signUpButton).isDisplayed();
    }
}
