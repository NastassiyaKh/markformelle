package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;

public class HomePage extends BasePage {
    public static final String URL = "https://markformelle.by";
    public static final By MAIN_CAROUSEL = By.xpath("//div[@class='main-carousel-wrap']");
    public static final By CONTAINER_CAROUSEL = By.xpath("//div[@class='actual-container owl-carousel']");

    public boolean isHomePageElementsDisplayed() {
        ArrayList<WebElement> webElementArrayList = new ArrayList<>();
        webElementArrayList.add(driver.findElement(MAIN_CAROUSEL));
        webElementArrayList.add(driver.findElement(CONTAINER_CAROUSEL));
        for (WebElement webElement : webElementArrayList) {
            if (!webElement.isDisplayed()) {
                return false;
            }
        }
        return true;
    }
}
