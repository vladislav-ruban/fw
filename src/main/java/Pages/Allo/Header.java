package Pages.Allo;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Pages.BasePage;

public class Header extends BasePage {
    public Header(WebDriver driver) {
        super(driver);
        initialWait(driver);
    }

    @Override
    public void initialWait(WebDriver driver) {
        waitUtils.waitForElementToBeVisible(searchBar);
    }

    @FindBy(xpath = ".//input[@id='search-form__input']")
    private WebElement searchBar;

    @FindBy(xpath = ".//button[@class='authentication__button--login']")
    private WebElement loginButton;

    @FindBy(xpath = ".//div[@class='name-container']/span")
    private WebElement actualNameSpan;

    public void clickLoginButton() {
        waitUtils.waitForElementToBeVisible(loginButton);
        loginButton.click();
    }

    public void searchFor(String searchQuery) {
        waitUtils.waitForElementToBeClickable(searchBar);
        searchBar.click();
        searchBar.sendKeys(searchQuery);
        searchBar.submit();
    }

    public void verifyName(String expectedName) {
        waitUtils.waitForElementToBeVisible(actualNameSpan);
        String actualName = actualNameSpan.getText();
        Assertions.assertThat(actualName)
                  .as("Wrong name on header\nExpected:%s\nActual:%s", expectedName, actualName)
                  .isEqualTo(expectedName);
    }
}
