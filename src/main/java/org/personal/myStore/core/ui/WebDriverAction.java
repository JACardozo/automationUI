package org.personal.myStore.core.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverAction {
    private WebDriver driver;
    private WebDriverWait wait;

    public WebDriverAction(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void click(final WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element))
                .click();
    }

    public void click(final By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    public void waitVisibility(final WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitVisibility(final By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void mouseOver(WebElement webElement) {
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).perform();
    }

    public void scrolling(WebElement webElement) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", webElement);
    }

    public void pause(final int timeOut) {
        try {
            Thread.sleep(timeOut);
        } catch (InterruptedException e) {
            System.out.printf("Error in the sleep: ", e);
            Thread.currentThread().interrupt();
        }
    }
}
