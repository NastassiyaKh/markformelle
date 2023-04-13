package pages;

import driver.Driver;
import org.openqa.selenium.WebDriver;

public class BasePage {
    public WebDriver driver;

    public BasePage() {
        driver = Driver.getDriver();
    }
}
