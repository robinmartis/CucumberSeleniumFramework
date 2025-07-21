package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResetPasswordPage {
	
	WebDriver driver;

	By header = By.xpath("//h2[contains(text(),'Find Your Account')]");
	
    public ResetPasswordPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public String getHeaderText() {
        return driver.findElement(header).getText(); 
    }


}
