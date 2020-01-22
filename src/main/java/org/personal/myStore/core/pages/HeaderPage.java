package org.personal.myStore.core.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.personal.myStore.core.ui.AbstractPage;

public class HeaderPage extends AbstractPage {

    @FindBy(css = "img.logo")
    private WebElement logo;

    @FindBy(className = "header-container")
    private WebElement header;

    @FindBy(className = "shopping_cart")
    private WebElement cart;

    @FindBy(css = "input#search_query_top")
    private WebElement searchInput;

    @FindBy(css = "button.button-search")
    private WebElement searchBtn;

    @FindBy(css = "div#contact-link a")
    private WebElement contactUsLink;

    public HeaderPage() {
        action.waitVisibility(logo);
    }

    public SearchPage searchFor(String keyWordToSearch) {
        searchInput.clear();
        searchInput.sendKeys(keyWordToSearch);
        action.click(searchBtn);
        return new SearchPage();
    }

    public ContactUsPage navigateTo(String pageName) {
        action.click(contactUsLink);
        return new ContactUsPage();
    }
}
