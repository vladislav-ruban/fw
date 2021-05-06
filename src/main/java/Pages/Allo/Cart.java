package Pages.Allo;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import Pages.BasePage;

public class Cart extends BasePage {
    public Cart(WebDriver driver) {
        super(driver);
        initialWait(driver);
    }

    @Override
    public void initialWait(WebDriver driver) {
        waitUtils.waitForElementToBeVisible(cartPopup);
    }

    @FindBy(xpath = ".//div[contains(@class, 'cart-popup checkout_modal')]")
    private WebElement cartPopup;

    @FindBy(xpath = ".//div[contains(@class, 'cart-popup checkout_modal')]//li//div[@class='product__item']/div[@class='content']/div[@class='title']")
    private List<WebElement> productCardsTitles;

    public void verifyThatProductIsInCart(String productName) {
        waitUtils.waitForElementsToBeVisible(productCardsTitles);
        List<String> productCardsTitlesNames = new ArrayList<>();

        for (WebElement title : productCardsTitles) {
            productCardsTitlesNames.add(title.getText());
        }

        Assertions.assertThat(productCardsTitlesNames.stream().anyMatch(n -> n.equals(productName)))
                  .as("%s product is not in the cart", productName)
                  .isTrue();
    }
}
