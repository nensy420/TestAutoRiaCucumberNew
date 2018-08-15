package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static tools.Waiters.waitPageToLoad;
import static tools.Waiters.waitVisibility;

public class HeadersLinksPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@id='header']//nav[@class='nav-head']/a[contains(text(),'RIA.com')]")
    private WebElement riaCom;

    @FindBy(xpath = "//div[@id='header']//nav[@class='nav-head']/a[3]")
    private WebElement nedvizhemost;

    @FindBy(xpath = "//div[@id='header']//nav[@class='nav-head']/a[4]")
    private WebElement autotovary;

    @FindBy(xpath = "//div[@id='header']//nav[@class='nav-head']/a[5]")
    private WebElement autozapchastiny;

    @FindBy(xpath = "//div[@class='container']//span[contains(@class,'middle')]/input")
    private WebElement elementOnRiaCom;

    @FindBy(id = "mainSearchForm")
    private WebElement elementOnNeruhomist;

    @FindBy(xpath = "//div[@class='container']//div[@class='wrapper']")
    private WebElement elementOnAutotovary;

    @FindBy(xpath = "//div[@class='wrapping']//form[@class='search-main']")
    private WebElement elementOnAutozapchastiny;

    private static final Logger log = LogManager.getLogger(HeadersLinksPage.class);

    public HeadersLinksPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private String getTitle() {
        String actualTitle = driver.getTitle();
        log.info("Get actual title");
        return actualTitle;
    }

    private String getUrl() {
        String currentUrl = driver.getCurrentUrl();
        log.info("Get current URL");
        return currentUrl;
    }

    public void clickOnRiaComLink() {
        waitVisibility(riaCom).click();
        log.info("Click on RiaCom link");
    }

    private String getMainWindowHandle() {
        String parentHandle = driver.getWindowHandle();
        log.info("Get parent window");
        return parentHandle;
    }

    public void switchToNewWindows() {
        for (String winHandle : driver.getWindowHandles()) {
            waitPageToLoad(driver, 10);
            driver.switchTo().window(winHandle);
            waitPageToLoad(driver, 10);
            log.info("Switch to new window");
        }
    }

    public void switchToOriginalWindow() {
        driver.close();
        driver.switchTo().window(getMainWindowHandle());
        log.info("Close new window and switch to the parent window");
    }

    public boolean checkLoadPageRiaCom(String expectedTitle, String expectedUrl) {
        Assert.assertTrue(getTitle().equals(expectedTitle) && getUrl().equals(expectedUrl) && elementOnRiaCom.isDisplayed());
        log.info("The page Ria.com was successfully loaded");
        return true;
    }

    public void clickOnNedvizhemostLink() {
        waitVisibility(nedvizhemost).click();
        log.info("Click on https://dom.ria.com/ link");
    }

    public boolean checkLoadNedvizhemost(String expectedTitle, String expectedUrl) {
        Assert.assertTrue(getTitle().equals(expectedTitle) && getUrl().equals(expectedUrl) && elementOnNeruhomist.isDisplayed());
        log.info("The page https://dom.ria.com/ was successfully loaded");
        return true;
    }

    public void clickOnAutotovariLink() {
        waitVisibility(autotovary).click();
        log.info("Click on https://market.ria.com/ link");
    }

    public boolean checkLoadAutotovary(String expectedTitle, String expectedUrl) {
        Assert.assertTrue(getTitle().equals(expectedTitle) && getUrl().equals(expectedUrl) && elementOnAutotovary.isDisplayed());
        log.info("The page https://market.ria.com/ was successfully loaded");
        return true;
    }

    public void clickOnAutozapchastinyLink() {
        waitVisibility(autozapchastiny).click();
        log.info("Click on https://zapchasti.ria.com/ link");
    }

    public boolean checkLoadAutozapchastiny(String expectedTitle, String expectedUrl) {
        Assert.assertTrue(getTitle().equals(expectedTitle) && getUrl().equals(expectedUrl) && elementOnAutozapchastiny.isDisplayed());
        log.info("The page https://zapchasti.ria.com/ was successfully loaded");
        return true;
    }

}
