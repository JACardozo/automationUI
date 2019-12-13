package org.personal.myStore.core.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.personal.myStore.core.ui.driver.DriverManager;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebDriverAction action;

    @FindBy(id="home-page-tabs")
    protected WebElement pageTabs;

    @FindBy(className = "blockbestsellers")
    protected WebElement bestSellers;

    @FindBy(className = "shopping_cart")
    protected WebElement cart;

    protected AbstractPage() {
        this.driver = DriverManager.getInstance().getDriver();
        this.wait = DriverManager.getInstance().getWait();
        this.action = new WebDriverAction(driver, wait);
        PageFactory.initElements(this.driver, this);
    }
}
