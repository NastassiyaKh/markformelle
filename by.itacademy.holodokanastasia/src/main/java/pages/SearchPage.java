package pages;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import util.Util;

import java.io.IOException;
import java.util.ArrayList;

public class SearchPage extends BasePage {
    private static final By LOGO_SEARCH = By.xpath("//div[@class='fix-block header-search']/*[name()='svg' and @class='search-icon desktop light_theme']/*");
    private static final By INPUT_SEARCH = By.xpath("//div[@class='fix-block header-search is-open']/input[@type='search']");
    private static final String CSS_QUERY_CLASS_FOR_PRODUCTS = ".catalog-item";

    public String inputSearchRequest(String request) {
        Util.waitForElementLocatedBy(driver, SearchPage.LOGO_SEARCH);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(SearchPage.LOGO_SEARCH)).click().build().perform();
        driver.findElement(SearchPage.INPUT_SEARCH).sendKeys(request);
        driver.findElement(SearchPage.INPUT_SEARCH).sendKeys(Keys.ENTER);
        return driver.getCurrentUrl();
    }

    public ArrayList<String> collectAllSearchFoundResults(String currentUrl) {
        Document doc;
        try {
            doc = Jsoup.connect(currentUrl).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Elements products = doc.select(CSS_QUERY_CLASS_FOR_PRODUCTS);
        ArrayList<String> productList = new ArrayList<>();
        for (Element product : products) {
            productList.add(product.text());
        }
        return productList;
    }

    public boolean areAllElementsContainsRequest(ArrayList<String> products, String request) {
        boolean allMatch = true;
        for (String item : products) {
            if (!item.toLowerCase().contains(request)) {
                allMatch = false;
                break;
            }
        }
        return allMatch;
    }
}
