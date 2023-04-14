package steps;

public class CartStep extends BaseStep {

    public boolean isAddingInCartItemMatchLyingInCart() {
        String idOfFirstSuitableItem = cartPage.clickCatalog()
                .clickSales()
                .chooseFirstSuitableItem();
        String modelOfItem = cartPage.clickOnItem(idOfFirstSuitableItem)
                .chooseSize()
                .addInCart();
        return cartPage.checkAddingTheSameItemInCart(modelOfItem);
    }
}

