package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import Pages.ProductPage;
import base.BaseTest;

public class ProductTest extends BaseTest {
    
    @Test
    public void testProductDetailsAndAddToCart() {
        
        driver.get("https://www.demoblaze.com/index.html");
        
        
        driver.manage().deleteAllCookies();
        executeJavaScript("window.localStorage.clear();");
        
        
        driver.navigate().refresh();
        
       
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productLink = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//a[contains(text(),'Samsung galaxy s6')]")));
        
        
        String expectedProductName = productLink.getText();
        productLink.click();
        
     
        wait.until(ExpectedConditions.urlContains("prod.html"));
        
        
        ProductPage productPage = new ProductPage(driver);
        
      
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='name']")));
        String actualProductTitle = productPage.getProductTitle();
        String productPrice = productPage.getProductPrice();
        
       
        Assert.assertEquals(actualProductTitle, expectedProductName, "Product title should match the selected product");
        Assert.assertTrue(productPrice.contains("$"), "Product price should contain $ symbol");
        
       
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//a[contains(text(),'Add to cart')]")));
        addToCartButton.click();
        
        
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        
       
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        
        WebElement cartLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("cartur")));
        cartLink.click();
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.id("page-wrapper")));
        
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
       
        boolean productInCart = false;
        
        try {
           
            WebElement cartTable = driver.findElement(By.cssSelector("table.table"));
            
            // Check if the product name appears anywhere on the page
            String pageSource = driver.getPageSource();
            if (pageSource.contains(expectedProductName)) {
                productInCart = true;
                System.out.println("Product found in page source: " + expectedProductName);
            } else {
                System.out.println("Product NOT found in page source: " + expectedProductName);
                System.out.println("Page source: " + pageSource);
            }
            
            // If still not found, try another approach
            if (!productInCart) {
                java.util.List<WebElement> allElements = driver.findElements(By.tagName("td"));
                for (WebElement element : allElements) {
                    String text = element.getText();
                    System.out.println("Found table cell: " + text);
                    if (text.contains(expectedProductName)) {
                        productInCart = true;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error checking cart: " + e.getMessage());
            e.printStackTrace();
        }
        
        Assert.assertTrue(productInCart, "The product should be added to the cart");
    }
    
    // Helper method to execute JavaScript
    private Object executeJavaScript(String script) {
        return ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(script);
    }
}