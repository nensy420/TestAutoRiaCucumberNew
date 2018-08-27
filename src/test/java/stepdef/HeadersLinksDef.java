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

    @Then("^The page https://www.ria.com/ was successfully loaded")
    public void thePageHttpsWwwRiaComWasSuccessfullyLoaded() {
        HeadersLinksPage headersLinksPage = new HeadersLinksPage(getDriver());
        String expectedTitle = "RIA.com ™ — доска бесплатных частных объявлений Украины.";
        String expectedUrl = "https://www.ria.com/";
        Assert.assertTrue(headersLinksPage.checkLoadPageRiaCom(expectedTitle, expectedUrl), "The page do not loaded");
    }

    @Given("^The user click on Dom.ria.com link$")
    public void theUserClickOnDomRiaComLink() {
        HeadersLinksPage headersLinksPage = new HeadersLinksPage(getDriver());
        headersLinksPage.clickOnNedvizhemostLink();
    }

    @Then("^The page https://dom.ria.com/ was successfully loaded")
    public void thePageHttpsDomRiaComWasSuccessfullyLoaded() {
        HeadersLinksPage headersLinksPage = new HeadersLinksPage(getDriver());
        String expectedTitle = "DOM.RIA™ — вся недвижимость Украины. Продажа и аренда любой недвижимости.";
        String expectedUrl = "https://dom.ria.com/?utm_source=auto_ria&utm_medium=text_link&utm_content=nedvigimost&utm_campaign=header";
        Assert.assertTrue(headersLinksPage.checkLoadNedvizhemost(expectedTitle, expectedUrl), "The page do not loaded");
    }

    @Given("^The user click on Автотовары link$")
    public void theUserClickOnAutotovaryLink() {
        HeadersLinksPage headersLinksPage = new HeadersLinksPage(getDriver());
        headersLinksPage.clickOnAutotovariLink();
    }

    @Then("^The page https://market.ria.com/ was successfully loaded")
    public void thePageHttpsMarketRiaComWasSuccessfullyLoaded() {
        HeadersLinksPage headersLinksPage = new HeadersLinksPage(getDriver());
        String expectedTitle = "MARKET.RIA — шины, диски и аксессуары для авто по выгодным ценам";
        String expectedUrl = "https://market.ria.com/?utm_source=auto.ria.com&utm_medium=text_link&utm_content=magazin_avtotovarov&utm_campaign=header";
        Assert.assertTrue(headersLinksPage.checkLoadAutotovary(expectedTitle, expectedUrl), "The page do not loaded");
    }

    @Given("^The user click on Автозапчасти link$")
    public void theUserClickOnAutozapchastyLink() {
        HeadersLinksPage headersLinksPage = new HeadersLinksPage(getDriver());
        headersLinksPage.clickOnAutozapchastinyLink();
    }

    @Then("^The page https://zapchasti.ria.com/ was successfully loaded")
    public void thePageHttpsZapchastiRiaComWasSuccessfullyLoaded() {
        HeadersLinksPage headersLinksPage = new HeadersLinksPage(getDriver());
        String expectedTitle = "1 000 000+ запчастей на авто в Украине на ZAPCHASTI.RIA";
        String expectedUrl = "https://zapchasti.ria.com/";
        Assert.assertTrue(headersLinksPage.checkLoadAutozapchastiny(expectedTitle, expectedUrl), "The page do not loaded");
    }

}
