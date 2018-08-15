package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import static tools.Waiters.waitToBeClickable;

public class SearchPageResults {
    private WebDriver driver;

    @FindBy(xpath = "//div[@id='emptyResultsBlock']//div[@id='emptyResultsNotFoundBlock' and not(contains(@class,'hide'))]//div[@class='title']")
    private WebElement mainPageSearchErrorMessage;

    @FindBy(xpath = "//div[@class= 'content']//div[@class= 'head-ticket']//a[@class='address']")
    private List<WebElement> resultBrandMark;

    @FindBy(xpath = "//div[@class= 'definition-data']//following-sibling::li[contains(@class,'view-location')]")
    private List<WebElement> resultRegion;

    @FindBy(xpath = "//div[@class= 'content']//div[@class= 'head-ticket']//a[@class='address']")
    private List<WebElement> resultYear;

    @FindBy(xpath = "//div[@class= 'content']//div[@class='price-ticket']/span[@class='size15']/span[@data-currency='USD']")
    private List<WebElement> resultPrice;

    private static final Logger log = LogManager.getLogger(SearchPageResults.class);

    public SearchPageResults(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public boolean resultsOfSearchBrandAndMark(String brandName, String markName) {
        List<WebElement> listOfResults = resultBrandMark;
        boolean result = false;
        for (WebElement elm : listOfResults) {
            waitToBeClickable(elm);
            result = elm.getText().trim().contains(brandName + " " + markName);
            if (!result) break;
        }
        log.info("Check the results of search for the brand and mark car");
        return result;
    }

    public boolean getResultsOfSearchRegion(String listOfCitiesNames) {
        List<WebElement> listOfResults = resultRegion;
        boolean result = false;
        for (WebElement elm : listOfResults) {
            waitToBeClickable(elm);
            result = listOfCitiesNames.contains(elm.getText());
            if (!result) break;
        }
        log.info("Check the results of search for the region");
        return result;
    }

    public boolean getResultsOfSearchYear(String yearFrom, String yearTo) {
        List<WebElement> listOfResults = resultYear;
        boolean result = false;
        for (WebElement elm : listOfResults) {
            waitToBeClickable(elm);

            result = ((Integer.parseInt(yearFrom)) <= (Integer.parseInt(elm.getText().substring(elm.getText().length() - 4))) && (Integer.parseInt(elm.getText().substring(elm.getText().length() - 4))) <= (Integer.parseInt(yearTo)));
            if (!result) break;
        }
        log.info("Check the results of search for the year");
        return result;
    }

    public boolean getResultsOfSearchPrice(String priceFrom, String priceTo) {
        List<WebElement> listOfResults = resultPrice;
        boolean result = false;
        for (WebElement elm : listOfResults) {
            waitToBeClickable(elm);

            result = ((Integer.parseInt(priceFrom)) <= (Integer.parseInt(elm.getAttribute("innerHTML").replaceAll("\\$|\\s", ""))) && (Integer.parseInt(elm.getAttribute("innerHTML").replaceAll("\\$|\\s", ""))) <= (Integer.parseInt(priceTo)));
            if (!result) break;
        }
        log.info("Check the results of search for the price");
        return result;
    }
}
