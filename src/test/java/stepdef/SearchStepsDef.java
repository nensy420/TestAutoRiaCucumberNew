package stepdef;



import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.MainPageSearch;
import pages.SearchPageResults;
import static config.ConfigForProperties.getUrl;
import static config.DriverManager.getDriver;

public class SearchStepsDef {
    @Given("^The user on AutoRia page$")
    public void theUserOnAutoRiaPage() {
        getDriver().get(getUrl());

    }

    @When("^The user enters the car brand \"([^\"]*)\",mark of the car\"([^\"]*)\" in the search form$")
    public void theUserEntersTheCarBrandMarkOfTheCarInTheSearchForm(String brandName, String markName) {
        MainPageSearch mainPageSearch = new MainPageSearch(getDriver());
        mainPageSearch.searchNameCar(brandName, markName);
    }

    @And("^The user clicks on search button$")
    public void theUserClicksOnSearchButton() {
        MainPageSearch mainPageSearch = new MainPageSearch(getDriver());
        mainPageSearch.clickOnSearchButton();
    }

    @Then("^The user sees that results of search match the specified search parameters  car brand\"([^\"]*)\" mark of the car\"([^\"]*)\"$")
    public void theUserSeesThatResultsOfSearchMatchTheSpecifiedSearchParametersCarBrandMarkOfTheCar(String brandName, String markName) {
        SearchPageResults searchPageResults = new SearchPageResults(getDriver());
        Assert.assertTrue(searchPageResults.resultsOfSearchBrandAndMark(brandName, markName), "The result of search for the brand and mark are not valid");
    }

    @When("^The user enters the year from \"([^\"]*)\",year to \"([^\"]*)\" in the search form$")
    public void theUserEntersTheYearFromYearToInTheSearchForm(String yearFrom, String yearTo) {
        MainPageSearch mainPageSearch = new MainPageSearch(getDriver());
        mainPageSearch.selectYear(yearFrom, yearTo);
    }

    @Then("^The user sees that results of search match the specified search parameters year from\"([^\"]*)\"  year to\"([^\"]*)\"$")
    public void theUserSeesThatResultsOfSearchMatchTheSpecifiedSearchParametersYearFromYearTo(String yearFrom, String yearTo) {
        SearchPageResults searchPageResults = new SearchPageResults(getDriver());
        Assert.assertTrue(searchPageResults.getResultsOfSearchYear(yearFrom, yearTo), "The result of search for the brand and mark are not valid");
    }

    @When("^The user enters the price from \"([^\"]*)\",price to \"([^\"]*)\" in the search form$")
    public void theUserEntersThePriceFromPriceToInTheSearchForm(String priceFrom, String priceTo) {
        MainPageSearch mainPageSearch = new MainPageSearch(getDriver());
        mainPageSearch.enterPrice(priceFrom, priceTo);
    }

    @Then("^The user sees that results of search match the specified search parameters price from \"([^\"]*)\" price to\"([^\"]*)\"$")
    public void theUserSeesThatResultsOfSearchMatchTheSpecifiedSearchParametersPriceFromPriceTo(String priceFrom, String priceTo) {
        SearchPageResults searchPageResults = new SearchPageResults(getDriver());
        Assert.assertTrue(searchPageResults.getResultsOfSearchPrice(priceFrom, priceTo), "The result of search for the brand and mark are not valid");
    }

    @When("^The user enters the region \"([^\"]*)\" in the search form$")
    public void theUserEntersTheRegionInTheSearchForm(String region) {
        MainPageSearch mainPageSearch = new MainPageSearch(getDriver());
        mainPageSearch.searchRegion(region);
    }

    @Then("^The user sees that results of search match the specified search parameters region \"([^\"]*)\"$")
    public void theUserSeesThatResultsOfSearchMatchTheSpecifiedSearchParametersRegion(String listOfCities) {
        SearchPageResults searchPageResults = new SearchPageResults(getDriver());
        Assert.assertTrue(searchPageResults.getResultsOfSearchRegion(listOfCities), "The result of search for the brand and mark are not valid");
    }
}
