package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static tools.Waiters.waitToBeClickable;

public class MainPageLogin {
    private WebDriver driver;

    @FindBy(xpath = "//div[@id='header']//div[@class='container']//span[@class='tl']")
    private WebElement enterTo;

    @FindBy(xpath = "//form[@id='login-form']/following-sibling::div[@class='login-link']/a")
    private WebElement registerLink;

    @FindBy(xpath = "//div[@class='login-rows']//following-sibling::input")
    private WebElement telephoneField;

    @FindBy(xpath = "//div[@class='sub-button']//following-sibling::input")
    private WebElement continueButton;

    @FindBy(id = "emailloginform-email")
    private WebElement emailField;

    @FindBy(id = "emailloginform-password")
    private WebElement passwardField;

    @FindBy(xpath = "//form[@id='login-form']/child::div[@class='login-link']//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//form[@id='login-form']/child::div[@class='login-rows']//p[@class='error']")
    private WebElement fieldAttantion;

    @FindBy(xpath = "//div[@id='gdprId']//following-sibling::label/span[@class='mhide']")
    private WebElement newWindow;

    private static final Logger log = LogManager.getLogger(MainPageLogin.class);

    private void clickOnRegistrateLink() {
        driver.switchTo().frame("login_frame");
        log.info("Switch to frame");
        waitToBeClickable(registerLink).click();
        log.info("Click on registration link");
    }

    public void clickOnLogin() {
        waitToBeClickable(enterTo).click();
        log.info("Click on login link");
    }

    public void clickOnRegister() {
        if (newWindow.isDisplayed()) {
            newWindow.click();
            clickOnRegistrateLink();
        } else {
            clickOnRegistrateLink();
        }
        log.info("Click on registration link");
    }

    public void inputTelephone(String number) {
        waitToBeClickable(telephoneField).sendKeys(number);
        log.info("Input the telephone number");
    }

    public void clickOnContinueButton() {
        waitToBeClickable(continueButton).click();
        log.info(" Click on the continue button");
    }

    public MainPageLogin(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private String getErrorMessageRegistration() {
        String attantionMessage = fieldAttantion.getAttribute("innerHTML");
        log.info(" Get the message");
        return attantionMessage;
    }

    public boolean checkTheErrorMassageDisplayed() {
        String errorMassage = "неверный  мобильный номер телефона";
        Assert.assertTrue(getErrorMessageRegistration().contains(errorMassage));
        log.info("The error massage is displayed on the screen");
        return true;
    }
}
