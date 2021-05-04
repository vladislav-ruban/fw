package Pages.Allo;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import Pages.BasePage;
import Utils.Converters;

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

    @FindBy(xpath = ".//div[@class='sort-by__select']")
    private WebElement sortBySelect;

    String sortByOptionsPattern = ".//ul[@class='sort-by__list']/li[text()='%s']";

    public void verifyThatAllProductCardsAreContainSearchQuery(String searchQuery) {
        List<String> productCardsTitlesString = new ArrayList<>();

        for (WebElement title : productCardsTitles)
            productCardsTitlesString.add(title.getText()
                                              .toLowerCase());

        productCardsTitlesString.forEach(pc -> Assertions.assertThat(pc.contains(searchQuery))
                                                         .as("Not all product cards are contain search query\n" +
                                                                 "Expected: %s\n" +
                                                                 "Actual: %s", searchQuery, pc)
                                                         .isTrue());
    }

    public void verifyThatAllProductCardsAreSortedByPriceLowToHigh() {
        List<Integer> productCardsPricesInt = new ArrayList<>();

        for (WebElement price : productCardsPrices)
            productCardsPricesInt.add(Converters.stringCutAndParseToInt(price.getText()));
        Integer[] productCardsPricesArray = (Integer[]) productCardsPricesInt.toArray(new Integer[productCardsPricesInt.size()]);
        boolean flag = true;
        for (int i = 1; i < productCardsPricesArray.length; i++) {
            flag = false;
            break;
        }

        Assertions.assertThat(flag)
                  .as("Prices are sorted high to low\n" +
                          "Expected: low to high")
                  .isTrue();
    }
}
