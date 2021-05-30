package Steps;

import org.openqa.selenium.WebDriver;

import Steps.Base.BaseUtil;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;

public class BrowserSteps extends BaseUtil {
    BaseUtil base;

    public BrowserSteps(BaseUtil base) {
        super();
        this.base = base;
    }

    public WebDriver getDriver() {
        return base.getDriver();
    }

    @Step
    @When("User navigates to previous page")
    public void userNavigatesToPreviousPage() {
        getDriver().navigate()
                   .back();
    }
}
