package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.SignupPage;
import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class HomePageTest extends BaseTest {
  
    HomePage homePage;
    LoginPage loginPage;

   @Test
    public void HomePageVerification() throws InterruptedException {
	   HomePage homePage = new HomePage(driver);
	    LoginPage loginPage = new LoginPage(driver);
    	
         
         homePage.areAllMenuItemsPresent();
         Assert.assertTrue(homePage.areAllMenuItemsPresent(), "One or more menu items are missing!");
         
         homePage.areAllCategoriesListed();
         Assert.assertTrue(homePage.areAllCategoriesListed(), "One or more product categories are missing!");
         
         //Verify that the application logo is visible
     	homePage.isLogoDisplayed();
         Assert.assertTrue(homePage.isLogoDisplayed(), "Application logo is not visible!");
         
         
         loginPage.clickLoginButton();
         loginPage.login("test@97", "admin"); 
        // Verify that the welcome user message is displayed
         homePage.isWelcomeMessageDisplayed();
        Assert.assertTrue(homePage.isWelcomeMessageDisplayed(), "Welcome user message is not displayed!");
        
        
 }
   
}
