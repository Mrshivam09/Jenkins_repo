package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {

    WebDriver driver;

    public SearchPage(WebDriver driver) {

        this.driver = driver;
    }

    By search = By.name("search");

    By searchBtn =
    By.xpath("//button[contains(@class,'btn-default')]");

    public void searchProduct(String product) {

        driver.findElement(search).sendKeys(product);
    }

    public void clickSearchButton() {

        driver.findElement(searchBtn).click();
    }
}
