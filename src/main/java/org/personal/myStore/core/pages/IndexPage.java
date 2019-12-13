package org.personal.myStore.core.pages;

import org.openqa.selenium.By;
import org.personal.myStore.core.ui.AbstractPage;

public class IndexPage extends AbstractPage {

    public BestSellersPage clickOnBestSellerOption() {
        action.waitVisibility(bestSellers);
        action.click(bestSellers);
        return new BestSellersPage();
    }

    public CartSummaryPage SelectFromCart(String option) {
        action.scrolling(cart);
        action.mouseOver(cart.findElement(By.xpath("//a[@Title='View my shopping cart']")));
        By locator = By.xpath("//div[@class='shopping_cart']//p[@class='cart-buttons']");
        action.waitVisibility(locator);
        action.click(locator);
        return new CartSummaryPage();
    }
}
