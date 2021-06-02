package Pages.Allo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Pages.BasePage;

public class LoginAndRegistrationPopup extends BasePage {

    public LoginAndRegistrationPopup(WebDriver driver) {
        super(driver);
        initialWait(driver);
    }

    @Override
    public void initialWait(WebDriver driver) {
        waitUtils.waitForElementToBeVisible(loginTabActive);
    }

    @FindBy(xpath = ".//li[@class='login-tab active']")
    private WebElement loginTabActive;

    @FindBy(xpath = ".//input[@name='email' and @id='auth']")
    private WebElement emailInput;

    @FindBy(xpath = ".//input[@type='password']")
    private WebElement passwordInput;

    @FindBy(xpath = ".//button[@class='modal-submit-button']")
    private WebElement submitButton;

    public void setEmailInput(String email) {
        emailInput.click();
        emailInput.sendKeys(email);
    }

    public void setPasswordInput(String password) {
        passwordInput.click();
        passwordInput.sendKeys(password);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }
}
