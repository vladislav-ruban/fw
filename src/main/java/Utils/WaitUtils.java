package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WaitUtils {
    private final int TIMEOUT = 15;

    WebDriver driver;
    private WebDriverWait wait;
    private Wait fluentWait;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT);
    }

    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForURLToContain(String expectedURLPart) {
        wait.until(ExpectedConditions.urlContains(expectedURLPart));
    }

    public void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementsToBeVisible(List<WebElement> listWebElements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(listWebElements));
    }

    public void waitForElementToBeInvisible(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForElementsToBeInvisible(List<WebElement> listWebElements) {
        wait.until(ExpectedConditions.invisibilityOfAllElements(listWebElements));
    }

    public void waitForElementToContainText(WebElement element) {
        if (!element.getText()
                    .isEmpty()) wait.until(driver -> element.getText()
                                                            .length() > 0);
    }

    public void waitForElementPresenceBy(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForElementsPresenceBy(By locator) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public void waitForElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForElementToBeVisibleAfterRefresh(WebElement element) {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
    }

    public void waitForElementsToBeVisibleAfterRefresh(List<WebElement> list) {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(list)));
    }
}
