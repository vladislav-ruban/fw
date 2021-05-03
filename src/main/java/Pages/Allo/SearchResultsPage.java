package Pages.Allo;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import Pages.BasePage;

public class SearchResultsPage extends BasePage {

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        initialWait(driver);
    }

    @Override
    public void initialWait(WebDriver driver) {
        waitUtils.waitForElementToBeVisible(activeViewModeButton);
    }

    @FindBy(xpath = ".//li[contains(@class,'view-mode__item--active')]/button")
    private WebElement activeViewModeButton;

    @FindBy(xpath = ".//a[@class='product-card__title']")
    private List<WebElement> productCardsTitles;

    @FindBy(xpath = ".//div[contains(@class, 'v-price-box__cur')]")
    private List<WebElement> productCardsPrices;

    public void verifyThatAllProductCardsAreContainSearchQuery(String searchQuery) {
        List<String> productCardsTitlesString = new ArrayList<>();
        for (WebElement title : productCardsTitles)
            productCardsTitlesString.add(title.getText()
                                              .toLowerCase());
        //assertThat(productCardsTitlesString, everyItem(containsString(searchQuery)));
        //Assertions.assertThat(productCardsTitlesString.stream().iterator().).as("Not all product cards are contain
        // search query").isTrue();
        productCardsTitlesString.forEach(pc -> Assertions.assertThat(pc.contains(searchQuery))
                                                         .as("Not all product cards are contain search query\n" +
                                                                 "Expected: %s\n" +
                                                                 "Actual: %s", searchQuery, pc)
                                                         .isTrue());
    }

    public void verifyThatAllProductCardsAreSortedByPriceLowToHigh() {

    }
}
