package stepdef;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.MainPageLogin;

import static config.DriverManager.getDriver;

public class LoginStepDef {
    @When("^The user click on Login link$")
    public void theUserClickOnLoginLink() {
        MainPageLogin mainPageLogin = new MainPageLogin(getDriver());
        mainPageLogin.clickOnLogin();
    }

    @When("^The user click on Sign up link$")
    public void theUserClickOnSignUpLink() {
        MainPageLogin mainPageLogin = new MainPageLogin(getDriver());
        mainPageLogin.clickOnRegister();
    }

    @When("^The user enters the wrong telephone = \"([^\"]*)\" number$")
    public void theUserEntersTheWrongTelephoneNumber(String telephone) {
        MainPageLogin mainPageLogin = new MainPageLogin(getDriver());
        mainPageLogin.inputTelephone(telephone);
    }

    @And("^The user clicks on submit button$")
    public void theUserClicksOnSubmitButton() {
        MainPageLogin mainPageLogin = new MainPageLogin(getDriver());
        mainPageLogin.clickOnContinueButton();
    }

    @Then("^The user watches the error message on the screen$")
    public void theUserWatchesTheErrorMessageOnTheScreen() {
        MainPageLogin mainPageLogin = new MainPageLogin(getDriver());
        Assert.assertTrue(mainPageLogin.checkTheErrorMassageDisplayed(), "The error massage is not displayed on the screen");
    }

}
