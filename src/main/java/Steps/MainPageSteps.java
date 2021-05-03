package Steps;

import org.openqa.selenium.WebDriver;

import Steps.Base.BaseUtil;
import io.cucumber.java.en.Given;
import io.qameta.allure.Step;

public class MainPageSteps extends BaseUtil {
    BaseUtil base;

    public MainPageSteps(BaseUtil base) {
        super();
        this.base=base;
    }

    public WebDriver getDriver() {
        return base.getDriver();
    }

    @Step
    @Given("User navigates to main page")
    public void userNavigatesToMainPage() {
        openMainPage();
    }
}
