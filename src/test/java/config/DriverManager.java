package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.BrowserType.*;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (ConfigForProperties.getBrowser()) {

                case FIREFOX:
                    System.setProperty("webdriver.gecko.driver", ConfigForProperties.getDriverPath());
                    driver = new FirefoxDriver();
                    break;
                case IE:
                    System.setProperty("webdriver.ie.driver", ConfigForProperties.getDriverPath());
                    driver = new InternetExplorerDriver();
                    break;
                case CHROME:
                    System.setProperty("webdriver.chrome.driver", ConfigForProperties.getDriverPath());
                    driver = new ChromeDriver();
                    break;
                default:
                    throw new WebDriverException("Driver is not defined.");
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
