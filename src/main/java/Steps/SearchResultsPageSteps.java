package Steps;

import org.openqa.selenium.WebDriver;

import Pages.Allo.SearchResultsPage;
import Steps.Base.BaseUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;

public class SearchResultsPageSteps extends BaseUtil {
    BaseUtil base;

    public SearchResultsPageSteps(BaseUtil base) {
        super();
        this.base=base;
    }

    public WebDriver getDriver() {
        return base.getDriver();
    }

    @Step
    @Then("Search results are contain {string} search query")
    public void searchResultsAreContainSearchQuery(String searchQuery) {
        SearchResultsPage searchResultsPage = new SearchResultsPage(getDriver());
        searchResultsPage.verifyThatAllProductCardsAreContainSearchQuery(searchQuery);
    }

    @Step
    @Then("Search results are sorted by price low to high")
    public void searchResultsAreSortedByPriceLowToHigh() {
        SearchResultsPage searchResultsPage = new SearchResultsPage(getDriver());
        searchResultsPage.verifyThatAllProductCardsAreSortedByPriceLowToHigh();
    }

    @Step
    @Then("Search results are sorted by price high to low")
    public void searchResultsAreSortedByPriceHighToLow() {
        SearchResultsPage searchResultsPage = new SearchResultsPage(getDriver());
        searchResultsPage.verifyThatAllProductCardsAreSortedByPriceHighToLow();
    }

    @Step
    @When("User select {string} sorting option")
    public void userSelectSortingOption(String optionName) {
        SearchResultsPage searchResultsPage = new SearchResultsPage(getDriver());
        searchResultsPage.selectSortingOption(optionName);
    }
}
