package Steps.Base;

import org.openqa.selenium.WebDriver;

import Utils.Property;

public class BaseUtil {

    private WebDriver driver;

    public WebDriver getDriver() { return driver; }

    public void setDriver(WebDriver driver) { this.driver = driver;}

    public void openMainPage() {
        getDriver().get(Property.getProperty("mainPage"));
    }
}