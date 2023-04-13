package ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HomePage;

public class HomeTest extends BaseTest {
    HomePage homePage = new HomePage();

    @Test
    public void testCheckMainElementsOfHomePage() {
        boolean reflectionOfHomePageMainElements = homePage.isHomePageElementsDisplayed();
        Assertions.assertTrue(reflectionOfHomePageMainElements);
    }
}
