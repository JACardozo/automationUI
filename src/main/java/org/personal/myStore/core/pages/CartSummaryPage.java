package org.personal.myStore.core.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.personal.myStore.core.ui.AbstractPage;

import java.util.List;

public class CartSummaryPage extends AbstractPage {

    @FindBy(id = "cart_summary")
    private WebElement cartSummaryTable;
    private String xpathBase = "";

    public String getAvailableValue(String item) {
        String locator = String.format("//tbody//a[contains(text(),'%s')]/ancestor::td/following-sibling::td/span", item);
        WebElement element = cartSummaryTable.findElement(By.xpath(locator));
        return element.getText();
    }

    public CartSummaryPage removeItem(String itemName) {
        String locator = String.format("//tbody//a[contains(text(),'%s')]/ancestor::td/following-sibling::td[contains(@class,'cart_delete')]//a", itemName);
        WebElement element = cartSummaryTable.findElement(By.xpath(locator));
        action.click(element);
        action.pause(5000);
        return new CartSummaryPage();
    }

    public boolean doesItemExist(String itemName) {
        List<WebElement> elements = driver.findElements(By.xpath("//tbody//a"));
        for (WebElement item : elements) {
            if (item.getText().equals(itemName)) {
                return true;
            }
        }
        return false;
    }

    public String getTotalPay() {
        WebElement element = cartSummaryTable.findElement(By.xpath("//tfoot//span[@id='total_price']"));
        String totalPay = element.getText();
        return totalPay.substring(1);
    }
}
