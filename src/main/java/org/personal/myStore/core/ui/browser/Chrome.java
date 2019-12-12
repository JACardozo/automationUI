package org.personal.myStore.core.ui.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome implements Browser {
    /**
     * Gets Chrome instance
     * @return the ChromeDriver.
     */
    @Override
    public WebDriver getBrowser() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
