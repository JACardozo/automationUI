package org.personal.myStore.core.ui.driver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.personal.myStore.core.Environment;

public class DriverManager {
    private static DriverManager instance = new DriverManager();
    private static final int TIME_OUT_IN_SECONDS = 30;
    private WebDriver driver;
    private WebDriverWait wait;

    /**
     * Gets driver instance.
     * @return DriverManager object.
     */
    public static DriverManager getInstance() {
        return instance;
    }

    private DriverManager() {
        String browser = Environment.getInstance().getValue("$['local']['browser']").toUpperCase();
        driver = DriverFactory.getDriverManager(DriverType.valueOf(browser));
        driver.manage().window().setSize(new Dimension(1200,768));
        wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);
        driver.get("http://automationpractice.com/index.php");
    }

    /**
     * Gets WebDriver.
     * @return WebDriver object.
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Gets WebDriverWait.
     * @return WebDriverWait object
     */
    public WebDriverWait getWait() {
        return wait;
    }
}
