package steps;

import java.util.ArrayList;

public class SearchStep extends BaseStep {

    public boolean areAllElementsContainsRequestAfterSearch(String request) {
        String currentUrl = searchPage.inputSearchRequest(request);
        ArrayList<String> products = searchPage.collectAllSearchFoundResults(currentUrl);
        return searchPage.areAllElementsContainsRequest(products, request);
    }
}
