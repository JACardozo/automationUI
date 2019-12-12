package org.personal.myStore.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.personal.myStore.core.ui.driver.DriverManager;
import org.testng.annotations.AfterTest;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org.personal.myStore"},
        plugin = {"pretty"}
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {
    /**
     * this method close the browser after the features finish.
     */
    @AfterTest
    public void close() {
        DriverManager.getInstance().getDriver().quit();
    }
}
