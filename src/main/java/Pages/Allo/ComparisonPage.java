package Pages.Allo;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import Pages.BasePage;

public class ComparisonPage extends BasePage {

    @FindBy(xpath = ".//a[@class='product-card__title']")
    private List<WebElement> productTitles;

    @FindBy(xpath = ".//div[@class='compare-page']")
    private WebElement compareHeaderContainer;

    public ComparisonPage(WebDriver driver) {
        super(driver);
        initialWait(driver);
    }

    @Override
    public void initialWait(WebDriver driver) {
        waitUtils.waitForElementToBeVisible(compareHeaderContainer);
    }

    public void isProductTitleDisplayed(String productName) {
        ArrayList<String> productTitlesString = new ArrayList<>();

        for (WebElement title : productTitles)
            productTitlesString.add(title.getText());

        Assertions.assertThat(productTitlesString.contains(productName))
                  .as("Product title %s is not displayed on comparison page\n" +
                          "Didplayed: %s", productName, productTitles)
                  .isTrue();
    }
}
