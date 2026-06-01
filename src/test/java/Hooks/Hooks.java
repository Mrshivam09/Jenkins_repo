package Hooks;

import Utilities.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setup() {

        BaseClass.setupBrowser();
    }

    @After
    public void tearDown() {

        BaseClass.closeBrowser();
    }
}