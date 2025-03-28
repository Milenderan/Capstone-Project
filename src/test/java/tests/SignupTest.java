package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.SignupPage;
import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

public class SignupTest extends BaseTest{

   @Test
    public void Signuptest() {
    	
	// Verify that the Sign Up button is visible
    	SignupPage signupPage = new SignupPage(driver);
    	
    	signupPage.isSignupButtonVisible();
        Assert.assertTrue(signupPage.isSignupButtonVisible(), "Sign Up button is not visible!");
        
      //Verify that the Sign Up is clickable
        signupPage.clickSignupButton();
        //Assert.assertTrue(signupPage.clickSignupButton(), "Signup button is not clickable");
       
        signupPage.isSignupModalDisplayed();
        Assert.assertTrue(signupPage.isSignupModalDisplayed(), "Signup window is not displayed");
    }

}
