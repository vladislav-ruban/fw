package Steps;

import org.openqa.selenium.WebDriver;

import Pages.Allo.ComparisonPage;
import Steps.Base.BaseUtil;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;

public class ComparisonPageSteps extends BaseUtil {
    BaseUtil base;

    public ComparisonPageSteps(BaseUtil base) {
        super();
        this.base=base;
    }

    public WebDriver getDriver() {
        return base.getDriver();
    }

    @Step
    @Then("User sees {string} product title on comparison page")
    public void userSeesProductTitleOnComparisonPage(String productTitle) {
        ComparisonPage comparisonPage = new ComparisonPage(getDriver());
        comparisonPage.isProductTitleDisplayed(productTitle);
    }
}
