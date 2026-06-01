
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {

    WebDriver driver;

    public LogoutPage(WebDriver driver) {

        this.driver = driver;
    }

    // -----------------------------------------
    // LOCATORS
    // -----------------------------------------

    By myAccount =
    By.xpath("//span[text()='My Account']");

    By logout =
    By.linkText("Logout");

    // -----------------------------------------
    // METHODS
    // -----------------------------------------

    public void clickMyAccount() {

        driver.findElement(myAccount).click();
    }

    public void clickLogout() {

        driver.findElement(logout).click();
    }
}
