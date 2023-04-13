package ui;

import driver.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class BaseTest {
    WebDriver driver;

    @BeforeEach
    public void warm() {
        driver = Driver.getDriver();
        driver.get(HomePage.URL);
    }

    @AfterEach
    public void cold() {
        Driver.closeDriver();
    }
}
