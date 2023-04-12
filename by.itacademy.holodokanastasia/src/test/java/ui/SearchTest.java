package ui;

import data.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import steps.SearchStep;

public class SearchTest extends BaseTest {
    SearchStep searchStep = new SearchStep();

    @Test
    public void testFindProductsByRequest() {
        boolean allElementsFromRequest = searchStep.areAllElementsContainsRequestAfterSearch(Product.product);
        Assertions.assertTrue(allElementsFromRequest);
    }
}
