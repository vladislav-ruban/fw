package Pages.Allo;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import Pages.BasePage;

public class ComparisonPage extends BasePage {

    public ComparisonPage(WebDriver driver) {
        super(driver);
        initialWait(driver);
    }

    @Override
    public void initialWait(WebDriver driver) {
        waitUtils.waitForElementToBeVisible(compareHeaderContainer);
    }

    @FindBy(xpath = ".//a[@class='product-name']")
    private List<WebElement> productTitles;

    @FindBy(xpath = ".//td[@class='compare-header']")
    private WebElement compareHeaderContainer;

    public void isProductTitleDisplayed(String productName) {
        ArrayList<String> productTitlesString = new ArrayList<>();

        for (WebElement title : productTitles)
            productTitlesString.add(title.getText());

        Assertions.assertThat(productTitlesString.contains(productName))
                  .as("Product title %s is not displayed on comparison page\n", productName)
                  .isTrue();
    }
}
