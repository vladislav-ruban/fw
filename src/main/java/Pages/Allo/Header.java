package Pages.Allo;

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

    public void searchFor(String searchQuery) {
        waitUtils.waitForElementToBeClickable(searchBar);
        searchBar.click();
        searchBar.sendKeys(searchQuery);
        searchBar.submit();
    }
}
