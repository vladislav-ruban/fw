package Pages.Csn;

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
        waitUtils.waitForElementToBeVisible(scrollPhotosSection);
    }

    @FindBy(xpath = ".//div[@class='scroll_photos']")
    private WebElement scrollPhotosSection;
}
