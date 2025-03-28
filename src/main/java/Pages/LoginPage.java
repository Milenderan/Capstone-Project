package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

import java.time.Duration;

public class LoginPage extends BaseTest {
    WebDriverWait wait;

    // Locators using @FindBy annotation
    @FindBy(id = "login2")  
    private WebElement loginButton;  // Login button on homepage

    @FindBy(id = "logInModal")  
    private WebElement loginModal;  // Login popup modal

    @FindBy(id = "loginusername")  
    private WebElement usernameField;  // Username input field

    @FindBy(id = "loginpassword")  
    private WebElement passwordField;  // Password input field

    @FindBy(xpath = "//button[contains(text(),'Log in')]")  
    private WebElement submitLoginButton;  // Submit button in modal

    @FindBy(id = "nameofuser")  
    private WebElement userWelcomeMessage;  // Welcome message after login

    // Constructor to initialize WebElements
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Check if Log In button is visible
    public boolean isLoginButtonVisible() {
        return loginButton.isDisplayed();
    }

    // Click the Log In button
    public boolean clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
		return false;
    }

    // Check if Log In modal appears
    public boolean isLoginModalDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(loginModal));
        return loginModal.isDisplayed();
    }

    // Perform login action
    public void login(String username, String password) {
        wait.until(ExpectedConditions.visibilityOf(usernameField)).sendKeys(username);
        passwordField.sendKeys(password);
        submitLoginButton.click();
    }

    // Verify if login was successful by checking the welcome message
    public boolean isUserLoggedIn() {
        wait.until(ExpectedConditions.visibilityOf(userWelcomeMessage));
        return userWelcomeMessage.isDisplayed();
        
    }


    
}
