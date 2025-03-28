package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AddingtoCart {
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    public AddingtoCart(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.js = (JavascriptExecutor) driver;
    }

    public void selectProduct(String productName) {
        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//a[contains(text(),'" + productName + "')]")
        ));
        product.click();
    }

    public void addToCart() {
        // Multiple strategies to find and click Add to Cart
        By[] addToCartLocators = {
            By.xpath("//a[contains(text(),'Add to cart')]"),
            By.xpath("//a[text()='Add to cart']"),
            By.partialLinkText("Add to cart")
        };

        for (By locator : addToCartLocators) {
            try {
                WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(locator));
                
                // Try regular click first
                try {
                    addButton.click();
                } catch (Exception e) {
                    // Fallback to JavaScript click
                    js.executeScript("arguments[0].click();", addButton);
                }

                // Wait and handle alert
                wait.until(ExpectedConditions.alertIsPresent());
                driver.switchTo().alert().accept();
                return;
            } catch (Exception e) {
                // Continue to next locator if current one fails
                continue;
            }
        }

        // If all methods fail, throw exception
        throw new RuntimeException("Could not find Add to Cart button");
    }

    public int getCartItemCount() {
        WebElement cartLink = wait.until(ExpectedConditions.elementToBeClickable(
            By.id("cartur")
        ));
        cartLink.click();
        
        return driver.findElements(By.xpath("//tr[@class='success']")).size();
    }
}