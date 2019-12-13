package org.personal.myStore.core.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.personal.myStore.core.ui.AbstractPage;

public class ItemAddedPage extends AbstractPage {

    @FindBy(className = "clearfix")
    private WebElement mainItemAddedPage;


    public IndexPage clickOnOption(String option) {
        String locator = String.format("//div[@class='button-container']/child::span[contains(@Title,'%s')]", option);
        WebElement element = mainItemAddedPage.findElement(By.xpath(locator));
        action.click(element);
        return new IndexPage();
    }
}
