package Pages.Allo;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    @FindBy(xpath = ".//div[@class='v-catalog v-сategory loading-block-gif']")
    private WebElement loadingSpinner;

    @FindBy(xpath = ".//a[@class='product-card__title']")
    private List<WebElement> productCardsTitles;

    @FindBy(xpath = ".//div[contains(@class, 'v-price-box__cur')]")
    private List<WebElement> productCardsPrices;

    @FindBy(xpath = ".//div[@class='sort-by__select']")
    private WebElement sortBySelect;

    @FindBy(xpath = ".//button[@class='compare-button compare-list__buttons-compare']")
    private WebElement compareBlueButton;

    String addProductToCartButtonPattern = ".//a[@title='%s']/following-sibling::div[@class='product-card__buy-box" +
            "']/button[contains(@class, 'buy-button')]";
    String sortByOptionsPattern = ".//ul[@class='sort-by__list']/li[text()='%s']";

    public void clickCompareBlueButton() {
        waitUtils.waitForElementToBeVisible(compareBlueButton);
        compareBlueButton.click();
    }

    public void clickAddProductToCartButton(String productName) {
        WebElement addToCartButton = driver.findElement(By.xpath(String.format(addProductToCartButtonPattern,
                productName)));
        addToCartButton.click();
    }

    public void clickProductTitle(String productName) {
        WebElement targetTitle = productCardsTitles.stream()
                                                   .filter(title -> title.getText()
                                                                         .equals(productName))
                                                   .findFirst()
                                                   .get();
        targetTitle.click();
    }

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
        waitUtils.waitForURLToContain("/dir-asc/order-price/");
        Integer[] productCardsPricesArray = listOfWebElementsParseToIntArray(productCardsPrices);

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

    public void verifyThatAllProductCardsAreSortedByPriceHighToLow() {
        waitUtils.waitForURLToContain("/dir-desc/order-price/");

        Integer[] productCardsPricesArray = listOfWebElementsParseToIntArray(productCardsPrices);

        boolean flag = true;
        for (int i = 1; i >= productCardsPricesArray.length; i++) {
            flag = false;
            break;
        }

        Assertions.assertThat(flag)
                  .as("Prices are sorted low to high\n" +
                          "Expected: high to low")
                  .isTrue();
    }

    private Integer[] listOfWebElementsParseToIntArray(List<WebElement> webElementsList) {
        List<Integer> integerList = new ArrayList<>();

        for (WebElement element : webElementsList)
            integerList.add(Converters.stringCutAndParseToInt(element.getText()));
        return (Integer[]) integerList.toArray(new Integer[integerList.size()]);
    }

    public void selectSortingOption(String optionName) {
        Actions action = new Actions(driver);
        action.moveToElement(sortBySelect)
              .perform();
        WebElement option = driver.findElement(By.xpath(String.format(sortByOptionsPattern, optionName)));
        option.click();
    }
}
