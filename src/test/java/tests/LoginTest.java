package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.LoginPage;
import Pages.SignupPage;
import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
public class LoginTest extends BaseTest{
      

    @Test
    public void testUserLogin() {
    	//LoginPage  loginPage = new LoginPage(driver); 
    	
    	LoginPage loginPage = new LoginPage(driver);
    	
    	loginPage.isLoginButtonVisible();
    	Assert.assertTrue(loginPage.isLoginButtonVisible(), "Login Button is not visible");
    	
    	loginPage.clickLoginButton();
    //	Assert.assertTrue(loginPage.clickLoginButton(), "Login button is not clickable");
    	loginPage.login("test@97", "admin");
    	
    	Assert.assertTrue(loginPage.isUserLoggedIn(), "user unable to login");
    	loginPage.isUserLoggedIn(); 
    	
    	
 }

}
