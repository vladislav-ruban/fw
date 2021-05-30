package Pages.Allo;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Pages.BasePage;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
        initialWait(driver);
    }

    @Override
    public void initialWait(WebDriver driver) {
        waitUtils.waitForElementToBeVisible(shippingBrandLink);
    }

    @FindBy(xpath = ".//a[@class='shipping-brand__link']")
    private WebElement shippingBrandLink;

    @FindBy(xpath = ".//div[@class='p-trade-wrapper p-main__trade']/descendant::div[@class='p-actions__item compare']")
    private WebElement addToCompareButton;

    @FindBy(xpath =
            ".//div[@class='p-trade-wrapper p-main__trade']/descendant::div[@class='p-actions__item compare active']")
    private WebElement getAddToCompareButtonActive;

    public void clickAddToCompareButtonOnMainTradePanel() {
        addToCompareButton.click();
    }

    public void isCompareButtonActiveOnMainTradePanel() {
        Assertions.assertThat(addToCompareButton.isDisplayed())
                  .as("Active compare button should be displayed")
                  .isTrue();
    }
}
