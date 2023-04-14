package ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import steps.CartStep;

public class CartTest extends BaseTest {
    CartStep cartStep = new CartStep();

    @Test
    public void testAddingItemInCartAndCheck() {
        boolean matchingPutAndLyingItemInCart = cartStep.isAddingInCartItemMatchLyingInCart();
        Assertions.assertTrue(matchingPutAndLyingItemInCart);
    }
}
