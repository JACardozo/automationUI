package org.personal.myStore.core.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.personal.myStore.core.ui.AbstractPage;

public class HeaderPage extends AbstractPage {

    @FindBy(className = "header-container")
    private WebElement header;

    @FindBy(className = "shopping_cart")
    private WebElement cart;

    private HeaderPage() {
    }
}
