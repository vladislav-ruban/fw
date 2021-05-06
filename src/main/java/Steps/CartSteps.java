package Steps;

import org.openqa.selenium.WebDriver;

import Pages.Allo.Cart;
import Steps.Base.BaseUtil;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;

public class CartSteps extends BaseUtil {
    BaseUtil base;

    public CartSteps(BaseUtil base) {
        super();
        this.base=base;
    }

    public WebDriver getDriver() {
        return base.getDriver();
    }

    @Step
    @Then("User sees {string} product in the cart")
    public void userSeesProductInTheCart(String productName) {
        Cart cart = new Cart(getDriver());
        cart.verifyThatProductIsInCart(productName);
    }
}
