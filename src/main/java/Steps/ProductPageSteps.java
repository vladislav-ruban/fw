package Steps;

import org.openqa.selenium.WebDriver;

import Pages.Allo.ProductPage;
import Steps.Base.BaseUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;

public class ProductPageSteps extends BaseUtil {
    BaseUtil base;

    public ProductPageSteps(BaseUtil base) {
        super();
        this.base=base;
    }

    public WebDriver getDriver() {
        return base.getDriver();
    }

    @Step
    @When("User clicks compare button on main trade panel")
    public void userClicksCompareButtonOnMainTradePanel() {
        ProductPage productPage = new ProductPage(getDriver());
        productPage.clickAddToCompareButtonOnMainTradePanel();
    }

    @Step
    @Then("Compare button is active on main trade panel")
    public void compareButtonIsActiveOnMainTradePanel() {
        ProductPage productPage = new ProductPage(getDriver());
        productPage.isCompareButtonActiveOnMainTradePanel();
    }
}
