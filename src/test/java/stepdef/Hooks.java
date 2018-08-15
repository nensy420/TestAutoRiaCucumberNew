package stepdef;

import cucumber.api.Scenario;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import static config.DriverManager.getDriver;
import static config.DriverManager.quitDriver;

public class Hooks {

    private static final Logger log = LogManager.getLogger(Hooks.class);

    @Before
    public void openPage(Scenario scenario) {
        getDriver();
        log.info("Get driver");
    }

    @After
    public void closePage(Scenario scenario) {
        quitDriver();
        log.info("Close Auto Ria");
    }
}
