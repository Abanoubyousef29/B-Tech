package TestCases;

import drivers.DriverFactory;
import drivers.DriverHolder;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TestBase {

    static protected WebDriver driver;
    protected SoftAssert softAssert = new SoftAssert();

    @BeforeTest()
    @Parameters("browserName")
    public void openHomePage(@Optional("defaultBrowser") String browserName) throws Exception {

        driver = DriverFactory.getNewInstance(browserName);
        DriverHolder.setDriver(driver);

        // set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));

        driver.get("https://btech.com/");

    }


    @AfterTest
    public void tearDown() throws Exception {
        if (driver!= null){
            driver.quit();
        }
    }
}
