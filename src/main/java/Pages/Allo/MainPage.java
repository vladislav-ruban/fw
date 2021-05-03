package Pages.Allo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Pages.BasePage;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
        initialWait(driver);
    }

    @Override
    public void initialWait(WebDriver driver) {
        waitUtils.waitForElementToBeVisible(homeBannerPagination);
    }

    @FindBy(xpath = "//div[@class='home-banner__pagination']")
    private WebElement homeBannerPagination;
}
