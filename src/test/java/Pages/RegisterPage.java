package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    WebDriver driver;

    public RegisterPage(WebDriver driver) {

        this.driver = driver;
    }

    By register = By.linkText("Register");

    By firstName = By.id("input-firstname");
    By lastName = By.id("input-lastname");
    By email = By.id("input-email");
    By phone = By.id("input-telephone");
    By password = By.id("input-password");
    By confirm = By.id("input-confirm");
    By policy = By.name("agree");
    By continueBtn =
    By.xpath("//input[@value='Continue']");

    public void clickRegister() {
        driver.findElement(register).click();
    }

    public void enterFirstName(String fname) {
        driver.findElement(firstName).sendKeys(fname);
    }

    public void enterLastName(String lname) {
        driver.findElement(lastName).sendKeys(lname);
    }

    public void enterEmail(String mail) {
        driver.findElement(email).sendKeys(mail);
    }

    public void enterPhone(String mobile) {
        driver.findElement(phone).sendKeys(mobile);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void enterConfirmPassword(String pass) {
        driver.findElement(confirm).sendKeys(pass);
    }

    public void clickPolicy() {
        driver.findElement(policy).click();
    }

    public void clickContinue() {
        driver.findElement(continueBtn).click();
    }
}
