package Steps;

import org.openqa.selenium.WebDriver;

import Pages.Allo.LoginAndRegistrationPopup;
import Steps.Base.BaseUtil;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;

public class LoginAndRegistrationPopupSteps extends BaseUtil {
    BaseUtil base;

    public LoginAndRegistrationPopupSteps(BaseUtil base) {
        super();
        this.base=base;
    }

    public WebDriver getDriver() {
        return base.getDriver();
    }

    @Step
    @When("User logs in with {string} email and {string} password")
    public void userLogsInWithEmailAndPassword(String email, String password) {
        LoginAndRegistrationPopup loginAndRegistrationPopup = new LoginAndRegistrationPopup(getDriver());
        loginAndRegistrationPopup.setEmailInput(email);
        loginAndRegistrationPopup.setPasswordInput(password);
        loginAndRegistrationPopup.clickSubmitButton();
    }
}
