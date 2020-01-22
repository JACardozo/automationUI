package org.personal.myStore.hooks;

import cucumber.api.java.Before;
import org.personal.myStore.core.ui.driver.DriverManager;

public class CommonHooks {
    @Before
    public void setUp() {
        DriverManager.getInstance().getDriver().navigate();
    }
}
