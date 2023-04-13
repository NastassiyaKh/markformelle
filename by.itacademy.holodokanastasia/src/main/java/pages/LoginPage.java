package pages;

import org.openqa.selenium.By;
import util.Util;

public class LoginPage extends BasePage {
    private static final By LINK_ENTER_PROFILE = By.xpath("//*[@class='icon icon-profile noscroll']");
    private static final By BUTTON_ENTER = By.xpath("//input[@value='Войти']");
    private static final By INPUT_EMAIL = By.xpath("//input[@placeholder='Email или логин ']");
    private static final By INPUT_PASSWORD = By.xpath("//input[@placeholder='Пароль']");
    private static final By LOGO_INVALID_DATA = By.xpath("//div[@class='choose-block email']//div[@class='error_message_form']");
    private static final By LOGO_MOMENT_PROFILE_NAME = By.xpath("//div[@class='choose-block email']//b");
    private static final By BUTTON_CLOSE_WELCOM_WINDOW = By.xpath("//button[@title='Close (Esc)']");
    private static final By BUTTON_LOGOUT = By.xpath("//input[@name='logout_butt']");
    private static final String ATTRIBUTE_LOGO_ENTER_PROFILE = "style";
    private static final String COLOR_OF_LOGO_ENTER_PROFILE = "fill: #ad1380;";


    public LoginPage openLoginForm() {
        Util.waitForElementVisLocatedBy(driver, LINK_ENTER_PROFILE);
        driver.findElement(LINK_ENTER_PROFILE).click();
        return this;
    }

    public LoginPage fillEmailInLoginForm(String email) {
        Util.waitForElementVisLocatedBy(driver, INPUT_EMAIL);
        driver.findElement(INPUT_EMAIL).sendKeys(email);
        return this;
    }

    public LoginPage fillPasswordInLoginForm(String password) {
        driver.findElement(INPUT_PASSWORD).sendKeys(password);
        return this;
    }

    public LoginPage clickEnter() {
        driver.findElement(BUTTON_ENTER).click();
        return this;
    }

    public String findProfileName() {
        Util.waitForElementVisLocatedBy(driver, LOGO_MOMENT_PROFILE_NAME);
        return driver.findElement(LOGO_MOMENT_PROFILE_NAME).getText();
    }

    public String findMessage() {
        Util.waitForElementVisLocatedBy(driver, LOGO_INVALID_DATA);
        return driver.findElement(LOGO_INVALID_DATA).getText();
    }

    public LoginPage closeWindowWithGreetings() {
        Util.waitForElementVisLocatedBy(driver, BUTTON_CLOSE_WELCOM_WINDOW);
        driver.findElement(BUTTON_CLOSE_WELCOM_WINDOW).click();
        return this;
    }

    public LoginPage logOut() {
        driver.findElement(LINK_ENTER_PROFILE).click();
        Util.waitForElementVisLocatedBy(driver, BUTTON_LOGOUT);
        driver.findElement(BUTTON_LOGOUT).click();
        return this;
    }

    public boolean checkAuthorizedUser() {
        Util.waitForElementVisLocatedBy(driver, LINK_ENTER_PROFILE);
        return driver.findElement(LINK_ENTER_PROFILE)
                .getAttribute(ATTRIBUTE_LOGO_ENTER_PROFILE)
                .equals(COLOR_OF_LOGO_ENTER_PROFILE);
    }
}
