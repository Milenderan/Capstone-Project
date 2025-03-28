package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

import java.time.Duration;

public class SignupPage extends BaseTest {
    WebDriverWait wait;

    // Locators using @FindBy annotation
    @FindBy(id = "signin2")  
    WebElement signupButton;
    
    @FindBy(id = "signInModal")  
    WebElement signupModal;

    // Constructor to initialize WebElements
    public SignupPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Check if the Sign Up button is visible
    public boolean isSignupButtonVisible() {
        return signupButton.isDisplayed();
    }

    // Click the Sign Up button
    public boolean clickSignupButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signupButton)).click();
		return false;
    }

    // Check if the Sign Up modal is displayed
    public boolean isSignupModalDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(signupModal));
        return signupModal.isDisplayed();
    }
}
