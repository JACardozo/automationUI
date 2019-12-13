package org.personal.myStore.core.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.personal.myStore.core.ui.AbstractPage;

public class BestSellersPage extends AbstractPage {

    @FindBy(id = "blockbestsellers")
    private WebElement bestSellerUl;

    public WebElement getArticle(String articleName) {
        return bestSellerUl.findElement(By.linkText(articleName));
    }

    public String getPriceReduction(String articleName) {
        WebElement element = getArticle(articleName).findElement(By.xpath("parent::h5/following-sibling::div/span[@class='price-percent-reduction']"));
        return element.getText().substring(1,element.getText().length()-1);
    }

    public ItemAddedPage clickOnAddToCart(String articleName) {
        WebElement webElement = getArticle(articleName);
        action.scrolling(webElement);
        action.mouseOver(webElement);
        action.waitVisibility(By.linkText("Add to cart"));
        By element = By.linkText("Add to cart");
        action.click(element);
        return new ItemAddedPage();
    }
}
