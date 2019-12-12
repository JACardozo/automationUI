package org.personal.myStore.core.ui.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements Browser {
    /**
     * Gets the Firefox instance
     * @return the FirefoxDriver.
     */
    @Override
    public WebDriver getBrowser() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
