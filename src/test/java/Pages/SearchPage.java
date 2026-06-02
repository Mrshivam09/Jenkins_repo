package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    By search = By.name("search");

    By searchBtn =
        By.xpath("//button[contains(@class,'btn-default')]");

    public void searchProduct(String product) {
        driver.findElement(search).clear();
        driver.findElement(search).sendKeys(product);
    }

    public void clickSearchButton() {

        WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement button =
            wait.until(ExpectedConditions.elementToBeClickable(searchBtn));

        try {
            button.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", button);
        }
    }
}
