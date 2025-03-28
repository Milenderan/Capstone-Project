package tests;

import Pages.PurchasePage;
import base.BaseTest;
import org.testng.annotations.Test;

public class PurchaseTest extends BaseTest {

    @Test
    public void testPurchaseProcess() throws InterruptedException {
        // Navigate to website
        driver.get("https://www.demoblaze.com/index.html");

        // Initialize Purchase Page
        PurchasePage purchasePage = new PurchasePage(driver);

        // Select product
        purchasePage.selectProduct();

        // Add to cart
        purchasePage.addToCart();

        // Handle alert
        
        Thread.sleep(1000); // Not recommended, but can help in some cases
        driver.switchTo().alert().accept();

        // Go to cart
        purchasePage.goToCart();

        // Place order
        purchasePage.placeOrder();

        // Fill purchase form
        purchasePage.fillPurchaseForm(
            "John Doe",      
            "United States", 
            "New York",      
            "1234567890",    
            "12",            
            "2025"           
        );

        // Click purchase button
        purchasePage.clickPurchaseButton();
    }
}
