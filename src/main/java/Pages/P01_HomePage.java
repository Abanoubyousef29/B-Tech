package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class P01_HomePage {

    // 1- define webdriver
    // 2- define constructor and initialize webdriver
    // 3- define locators using By
    // 4- define action methods for each locator

    WebDriver driver;

    public P01_HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By SEARCHBAR_FIELD = By.id("search");


    public P01_HomePage searchInSearchBar(String searchItem) {
        driver.findElement(this.SEARCHBAR_FIELD).sendKeys(searchItem+ Keys.ENTER);
        return this;
    }


}
