package org.personal.myStore.core.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.personal.myStore.core.ui.AbstractPage;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends AbstractPage {

    @FindBy(css = "h1.page-heading")
    private WebElement searchTitle;

    @FindBy(css = "ul.product_list")
    private WebElement searchedList;

    public SearchPage() {
        action.waitVisibility(searchTitle);
    }

    public List<String> getSearchResult() {
        List<String> produtcs = new ArrayList<String>();
        List<WebElement> produtcsTitle = searchedList.findElements(By.cssSelector("li a.product-name"));
        produtcsTitle.forEach( productTitle -> produtcs.add(productTitle.getText()));
        return produtcs;
    }
}
