package Steps.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import Utils.Property;

public class BaseUtil {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void openMainPage() {
        Actions action = new Actions(driver);
        action.moveByOffset(5, 5)
              .moveByOffset(10, 15)
              .moveByOffset(20, 15);
        getDriver().get(Property.getProperty("mainPage"));
        action.perform();
    }
}