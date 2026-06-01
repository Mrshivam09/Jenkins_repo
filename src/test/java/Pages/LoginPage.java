package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
    WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    By myAccount =
    By.xpath("//span[text()='My Account']");

    By login =
    By.linkText("Login");

    By email =
    By.id("input-email");

    By password =
    By.id("input-password");

    By loginBtn =
    By.xpath("//input[@value='Login']");

    public void clickMyAccount() {

        driver.findElement(myAccount).click();
    }

    public void clickLogin() {

        driver.findElement(login).click();
    }

    public void enterEmail(String mail) {

        driver.findElement(email).sendKeys(mail);
    }

    public void enterPassword(String pass) {

        driver.findElement(password).sendKeys(pass);
    }

    public void clickLoginButton() {

        driver.findElement(loginBtn).click();
    }
}