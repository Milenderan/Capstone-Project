package tests;

import Pages.LogoutPage;
import base.BaseTest;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        LogoutPage logoutPage = new LogoutPage(driver);
        logoutPage.login("test@97", "admin");
        Assert.assertTrue(logoutPage.isLogoutButtonDisplayed(), "Logout button not displayed after login");
        logoutPage.clickLogoutButton();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Assert.assertTrue(logoutPage.isLoginButtonDisplayed(), "Should be redirected to home page after logout");
    }
}