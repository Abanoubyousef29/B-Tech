package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P03_ProductPage {

    // 1- define webdriver
    // 2- define constructor and initialize webdriver
    // 3- define locators using By
    // 4- define action methods for each locator

    WebDriver driver;

    public P03_ProductPage(WebDriver driver) {

        this.driver = driver;
    }

    private final By IMAGE = By.xpath("//img[@itemprop='image']");
    private final By ADD_TO_THE_CART = By.xpath("//button[@id='product-addtocart-button']");
    private final By OPEN_CART = By.xpath("//button[contains(@class, 'go-to-cart-btn')]");


    public boolean imageAppear() {
        return driver.findElement(this.IMAGE).isDisplayed();
    }

    public P03_ProductPage clickOnAddToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ADD_TO_THE_CART));
        element.click();
        return this;
    }

    public P03_ProductPage openMyCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(OPEN_CART));
        element.click();
        return this;
    }

}
