package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

import java.time.Duration;

public class ProductPage extends BaseTest {
   
    WebDriverWait wait;
    
   
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    
  
     By productTitleLocator = By.xpath("//h2[@class='name']");
     By productPriceLocator = By.xpath("//h3[@class='price-container']");
     By productDescriptionLocator = By.xpath("//div[@id='more-information']/p");
     By addToCartButtonLocator = By.xpath("//a[contains(text(),'Add to cart')]");
    
    
    public String getProductTitle() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(productTitleLocator));
        return element.getText();
    }
    
    public String getProductPrice() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(productPriceLocator));
        return element.getText();
    }
    
    public String getProductDescription() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(productDescriptionLocator));
        return element.getText();
    }
    
    public void addToCart() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(addToCartButtonLocator));
        element.click();
    }
}