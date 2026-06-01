package Hooks;

import Utilities.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void beforeScenario() {

        BaseClass.setupBrowser();

        System.out.println("Browser Launched");
    }

    @After
    public void afterScenario() {

        BaseClass.closeBrowser();

        System.out.println("Browser Closed");
    }
}
