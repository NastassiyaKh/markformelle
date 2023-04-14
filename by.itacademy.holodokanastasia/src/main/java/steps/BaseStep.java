package steps;

import pages.CartPage;
import pages.LoginPage;
import pages.SearchPage;

public class BaseStep {
    LoginPage loginPage = new LoginPage();
    SearchPage searchPage = new SearchPage();
    CartPage cartPage = new CartPage();
}
