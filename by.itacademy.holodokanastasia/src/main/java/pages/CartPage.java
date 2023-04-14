package pages;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import util.Util;

import java.io.IOException;

public class CartPage extends BasePage {
    private static final By BUTTON_CART = By.xpath("//a[@class='header-cart btn-ico-basket']");
    private static final By BUTTON_CATALOG = By.xpath("//*[@class='hamburger-text']");
    private static final By BUTTON_SALES = By.xpath("//li[@class='main-li open']//a[@class='parent sale']");
    private static final By BUTTON_ALL_IN_SALES = By.xpath("//*[@href='/catalog/zhenshchinam/extra-sale/']");
    private static final By BUTTON_ADD_IN_CART = By.xpath("//*[contains(text(), 'Добавить в корзину')]");
    private static final By LINK_CHOOSING_SIZE = By.xpath("//div[@class='size-arrow']");
    private static final By BUTTON_CHOOSING_SIZE = By.xpath("//div[@class='size-table-row active-size']");
    private static final By ACTUAL_ITEM_MODEL = By.xpath("//span[@class='model-desktop']");
    private static final By ITEM_MODEL_IN_CART = By.xpath("//div[@class='info-item' and contains(text(), 'Модель: ')]/span[@class='props-name']");
    private static final String CSS_QUERY_CLASS_FOR_PRODUCTS = "li[class='catalog-item']";
    private static final String ATTRIBUTE_KEY = "data-product-id";
    private static final String ATTRIBUTE_ONLY_IN_AVAILABLE_ITEM = "addToBasket(this)";
    private static final String ATTRIBUTE_ONCLICK = "onclick";
    private static final String XPATH_BY_ID = "//li[@data-product-id='";
    private static final String XPATH_BY_SIZE_ITEM = "']//div[@class='size-item']";
    private static final String XPATH_BY_CATALOG_NAME_LINK = "']//a[@class='catalog-name__link']";

    public CartPage clickCatalog() {
        driver.findElement(BUTTON_CATALOG).click();
        return this;
    }

    public CartPage clickSales() {
        Util.waitForElementVisLocatedBy(driver, BUTTON_SALES);
        driver.findElement(BUTTON_SALES).click();
        driver.findElement(BUTTON_ALL_IN_SALES).click();
        return this;
    }

    public String chooseFirstSuitableItem() {
        Document doc;
        try {
            doc = Jsoup.connect(driver.getCurrentUrl()).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Element product = doc.select(CSS_QUERY_CLASS_FOR_PRODUCTS).first();
        while (product != null) {
            String id = product.attr(ATTRIBUTE_KEY);
            boolean elementAccessibility = false;
            try {
                elementAccessibility = driver.findElement(By.xpath(XPATH_BY_ID + id + XPATH_BY_SIZE_ITEM)).isEnabled();
            } catch (NoSuchElementException ignored) {}
            if (elementAccessibility) {
                String attr = driver.findElement(By.xpath(XPATH_BY_ID + id + XPATH_BY_SIZE_ITEM)).getAttribute(ATTRIBUTE_ONCLICK);
                if (attr.equals(ATTRIBUTE_ONLY_IN_AVAILABLE_ITEM)) {
                    return id;
                }
            } else {
                product = product.nextElementSibling();
            }
        }
        return null;
    }

    public CartPage clickOnItem(String id) {
        driver.findElement(By.xpath(XPATH_BY_ID + id + XPATH_BY_CATALOG_NAME_LINK)).click();
        return this;
    }

    public CartPage chooseSize() {
        Util.waitForElementVisLocatedBy(driver, LINK_CHOOSING_SIZE);
        driver.findElement(LINK_CHOOSING_SIZE).click();
        Util.waitForElementVisLocatedBy(driver, BUTTON_CHOOSING_SIZE);
        driver.findElement(BUTTON_CHOOSING_SIZE).click();
        return this;
    }

    public String addInCart() {
        Util.waitForElementVisLocatedBy(driver, BUTTON_ADD_IN_CART);
        driver.findElement(BUTTON_ADD_IN_CART).click();
        return driver.findElement(ACTUAL_ITEM_MODEL).getText();
    }

    public boolean checkAddingTheSameItemInCart(String string) {
        driver.findElement(BUTTON_CART).click();
        return string.contains(driver.findElement(ITEM_MODEL_IN_CART).getText());
    }
}
