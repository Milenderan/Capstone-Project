package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

import java.time.Duration;
import java.util.List;

public class HomePage extends BaseTest {
   
    WebDriverWait wait;

    // Welcome User message (displayed after login)
    @FindBy(id = "nameofuser")  
    private WebElement welcomeUserMessage;

    // Application logo
    @FindBy(id = "nava")  
    private WebElement appLogo;

    // Product categories container
    @FindBy(id = "contcont")
    private WebElement categoriesContainer;

    // Constructor to initialize elements
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Check if Welcome User message is displayed
    public boolean isWelcomeMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(welcomeUserMessage));
            return welcomeUserMessage.isDisplayed();
        } catch (Exception e) {
            System.out.println("Error checking welcome message: " + e.getMessage());
            return false;
        }
    }

    // Check if application logo is displayed
    public boolean isLogoDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(appLogo));
            return appLogo.isDisplayed();
        } catch (Exception e) {
            System.out.println("Error checking logo: " + e.getMessage());
            return false;
        }
    }

    // Check if all menu items are present
    public boolean areAllMenuItemsPresent() {
        try {
      
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("navbarExample")));
            
            // Check for each expected menu item with more flexible selectors
            boolean homePresent = isElementPresent(By.xpath("//a[contains(@class, 'nav-link') and contains(text(), 'Home')]"));
            boolean contactPresent = isElementPresent(By.xpath("//a[contains(@class, 'nav-link') and contains(text(), 'Contact')]"));
            boolean aboutUsPresent = isElementPresent(By.xpath("//a[contains(@class, 'nav-link') and contains(text(), 'About')]"));
            boolean cartPresent = isElementPresent(By.id("cartur"));
            boolean loginPresent = isElementPresent(By.id("login2"));
            boolean signupPresent = isElementPresent(By.id("signin2"));
            
           
            System.out.println("Menu Items Check Results:");
            System.out.println("Home: " + homePresent);
            System.out.println("Contact: " + contactPresent);
            System.out.println("About us: " + aboutUsPresent);
            System.out.println("Cart: " + cartPresent);
            System.out.println("Log in: " + loginPresent);
            System.out.println("Sign up: " + signupPresent);
            
            // All items must be present
            return homePresent && contactPresent && aboutUsPresent && 
                   cartPresent && loginPresent && signupPresent;
        } catch (Exception e) {
            System.out.println("Exception in areAllMenuItemsPresent: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

   
    private boolean isElementPresent(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            boolean isDisplayed = element.isDisplayed();
            if (!isDisplayed) {
                System.out.println("Element found but not displayed: " + locator);
            }
            return isDisplayed;
        } catch (Exception e) {
            System.out.println("Element not found: " + locator);
            return false;
        }
    }

  
    public boolean areAllCategoriesListed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(categoriesContainer));
            
          
            List<WebElement> categoryElements = driver.findElements(By.cssSelector("#contcont .list-group a"));
            
            String[] expectedCategories = {"CATEGORIES", "Phones", "Laptops", "Monitors"};
            
          
            if (categoryElements.size() < expectedCategories.length) {
                System.out.println("Not enough category elements found. Expected: " + expectedCategories.length + 
                                  ", Found: " + categoryElements.size());
                return false;
            }
            
           
            System.out.println("Category Elements Found: " + categoryElements.size());
            for (WebElement element : categoryElements) {
                System.out.println("Category: " + element.getText());
            }
            
            
            for (String expected : expectedCategories) {
                boolean found = false;
                for (WebElement element : categoryElements) {
                    if (element.getText().trim().equalsIgnoreCase(expected)) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Category not found: " + expected);
                    return false;
                }
            }
            
            return true;
        } catch (Exception e) {
            System.out.println("Exception in areAllCategoriesListed: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
