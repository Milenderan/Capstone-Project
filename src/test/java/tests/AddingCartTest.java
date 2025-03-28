package tests;

import Pages.AddingtoCart;
import Pages.LoginPage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddingCartTest extends BaseTest {
    @Test
    public void testProductDetailsAndCartAddition() {
        // Navigate to website
        driver.get("https://www.demoblaze.com/index.html");

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("test@97", "admin");

        // Initialize cart page
        AddingtoCart cartPage = new AddingtoCart(driver);

        // Select product
        String productName = "Samsung galaxy s6";
        cartPage.selectProduct(productName);

        // Add product to cart
        cartPage.addToCart();

        // Verify cart has increased
        int cartCount = cartPage.getCartItemCount();
        Assert.assertTrue(cartCount > 0, "Product should be added to cart");
    }
}