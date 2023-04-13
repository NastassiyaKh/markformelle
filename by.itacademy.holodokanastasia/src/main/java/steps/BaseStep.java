package steps;

import pages.LoginPage;
import pages.SearchPage;

public class BaseStep {
    LoginPage loginPage = new LoginPage();
    SearchPage searchPage = new SearchPage();
    CartStep cartStep = new CartStep();
}
