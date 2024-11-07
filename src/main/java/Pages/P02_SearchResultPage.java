package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P02_SearchResultPage {

    // 1- define webdriver
    // 2- define constructor and initialize webdriver
    // 3- define locators using By
    // 4- define action methods for each locator

    WebDriver driver;

    public P02_SearchResultPage(WebDriver driver) {

        this.driver = driver;
    }

    private final By RESULT_LIST = By.xpath("//*[contains(@class, 'find-search-list')]");

    public P02_SearchResultPage selectItemByNumber(String itemNumber) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for a specific element to be visible
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(RESULT_LIST)
                        .findElement(By.xpath("./div[" + itemNumber + "]"))
        ));
        element.click();
        return this;
    }
}
