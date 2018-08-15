package stepdef;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.HeadersLinksPage;
import static config.DriverManager.getDriver;


public class HeadersLinksDef {

    @Given("^The user click on Ria.com link$")
    public void theUserClickOnRiaComLink() {
        HeadersLinksPage headersLinksPage = new HeadersLinksPage(getDriver());
        headersLinksPage.clickOnRiaComLink();
    }

    @When("^The user switch to new window$")
    public void theUserSwitchToNewWindow() {
        HeadersLinksPage headersLinksPage = new HeadersLinksPage(getDriver());
        headersLinksPage.switchToNewWindows();
    }

    @Then("^The page https://www.ria.com/ was successfully loaded \"([^\"]*)\" \"([^\"]*)\"$")
    public void thePageHttpsWwwRiaComWasSuccessfullyLoaded(String expectedTitle, String expectedUrl) {
        HeadersLinksPage headersLinksPage = new HeadersLinksPage(getDriver());
        Assert.assertTrue(headersLinksPage.checkLoadPageRiaCom(expectedTitle, expectedUrl), "The page do not loaded");
    }

    @Given("^The user click on Dom.ria.com link$")
    public void theUserClickOnDomRiaComLink() {
        HeadersLinksPage headersLinksPage = new HeadersLinksPage(getDriver());
        headersLinksPage.clickOnNedvizhemostLink();
    }

    @Then("^The page https://dom.ria.com/ was successfully loaded \"([^\"]*)\" \"([^\"]*)\"$")
    public void thePageHttpsDomRiaComWasSuccessfullyLoaded(String expectedTitle, String expectedUrl) {
        HeadersLinksPage headersLinksPage = new HeadersLinksPage(getDriver());
        Assert.assertTrue(headersLinksPage.checkLoadNedvizhemost(expectedTitle, expectedUrl), "The page do not loaded");
    }

    @Given("^The user click on Автотовары link$")
    public void theUserClickOnAutotovaryLink() {
        HeadersLinksPage headersLinksPage = new HeadersLinksPage(getDriver());
        headersLinksPage.clickOnAutotovariLink();
    }

    @Then("^The page https://market.ria.com/ was successfully loaded \"([^\"]*)\" \"([^\"]*)\"$")
    public void thePageHttpsMarketRiaComWasSuccessfullyLoaded(String expectedTitle, String expectedUrl) {
        HeadersLinksPage headersLinksPage = new HeadersLinksPage(getDriver());
        Assert.assertTrue(headersLinksPage.checkLoadAutotovary(expectedTitle, expectedUrl), "The page do not loaded");
    }

    @Given("^The user click on Автозапчасти link$")
    public void theUserClickOnAutozapchastyLink() {
        HeadersLinksPage headersLinksPage = new HeadersLinksPage(getDriver());
        headersLinksPage.clickOnAutozapchastinyLink();
    }

    @Then("^The page https://zapchasti.ria.com/ was successfully loaded \"([^\"]*)\" \"([^\"]*)\"$")
    public void thePageHttpsZapchastiRiaComWasSuccessfullyLoaded(String expectedTitle, String expectedUrl) {
        HeadersLinksPage headersLinksPage = new HeadersLinksPage(getDriver());
        Assert.assertTrue(headersLinksPage.checkLoadAutozapchastiny(expectedTitle, expectedUrl), "The page do not loaded");
    }

}
