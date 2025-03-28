package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.BaseTest;
import java.time.Duration;

public class PurchasePage extends BaseTest {
    WebDriverWait wait;

    // Locators for Purchase Form Elements
    @FindBy(xpath = "//a[contains(text(),'Samsung galaxy s6')]")
    WebElement samsungGalaxyProduct;

    @FindBy(xpath = "//a[contains(text(),'Add to cart')]")
    WebElement addToCartButton;

    @FindBy(id = "cartur")
    WebElement cartButton;

    @FindBy(xpath = "//button[contains(text(),'Place Order')]")
    WebElement placeOrderButton;

    @FindBy(id = "name")
    WebElement nameInput;

    @FindBy(id = "country")
    WebElement countryInput;

    @FindBy(id = "city")
    WebElement cityInput;

    @FindBy(id = "card")
    WebElement cardInput;

    @FindBy(id = "month")
    WebElement monthInput;

    @FindBy(id = "year")
    WebElement yearInput;

    @FindBy(xpath = "//button[text()='Purchase']")
    WebElement purchaseButton;

    // Constructor to initialize WebElements
    public PurchasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Method to select product
    public void selectProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(samsungGalaxyProduct)).click();
    }

    // Method to add product to cart
    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    // Method to go to cart
    public void goToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartButton)).click();
    }

    // Method to place order
    public void placeOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton)).click();
    }

    // Method to fill purchase form
    public void fillPurchaseForm(String name, String country, String city, 
                                  String cardNumber, String month, String year) {
        wait.until(ExpectedConditions.visibilityOf(nameInput)).sendKeys(name);
        countryInput.sendKeys(country);
        cityInput.sendKeys(city);
        cardInput.sendKeys(cardNumber);
        monthInput.sendKeys(month);
        yearInput.sendKeys(year);
    }

    // Method to click purchase button
    public void clickPurchaseButton() {
        wait.until(ExpectedConditions.elementToBeClickable(purchaseButton)).click();
    }
}