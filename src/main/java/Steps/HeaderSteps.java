package Steps;

import org.openqa.selenium.WebDriver;

import Pages.Allo.Header;
import Steps.Base.BaseUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;

public class HeaderSteps extends BaseUtil {
    BaseUtil base;

    public HeaderSteps(BaseUtil base) {
        super();
        this.base=base;
    }

    public WebDriver getDriver() {
        return base.getDriver();
    }

    @Step
    @When("User enters {string} to search bar")
    public void userEntersSearchQueryToSearchBar(String searchQuery) {
        Header header = new Header(getDriver());
        header.searchFor(searchQuery);
    }

    @Step
    @Given("User clicks login button on main page")
    public void userClicksLoginButtonOnMainPage() {
        Header header = new Header(getDriver());
        header.clickLoginButton();
    }

    @Step
    @Then("User sees that he logged in as {string}")
    public void userSeesThatHeLoggedInAs(String accountFirstName) {
        Header header = new Header(getDriver());
        header.verifyName(accountFirstName);
    }
}
