package StepDefinition;

import org.junit.Assert;

import Pages.LoginPage;
import Pages.RegisterPage;
import Pages.SearchPage;
import Pages.LogoutPage;

import Utilities.BaseClass;

import io.cucumber.java.en.*;

public class TutorialsNinjaSteps {

    LoginPage lp =
    new LoginPage(BaseClass.driver);

    RegisterPage rp =
    new RegisterPage(BaseClass.driver);

    SearchPage sp =
    new SearchPage(BaseClass.driver);

    LogoutPage lop =
    new LogoutPage(BaseClass.driver);

    @Given("user opens Tutorials Ninja website")
    public void user_opens_tutorials_ninja_website() {

        System.out.println("Website Opened");
    }

    @When("user clicks on My Account")
    public void user_clicks_on_my_account() {

        lp.clickMyAccount();
    }

    @When("user clicks on Login option")
    public void user_clicks_on_login_option() {

        lp.clickLogin();
    }

    @When("user enters email {string}")
    public void user_enters_email(String email) {

        lp.enterEmail(email);
    }

    @When("user enters password {string}")
    public void user_enters_password(String password) {

        lp.enterPassword(password);
    }

    @When("user clicks on Login button")
    public void user_clicks_on_login_button() {

        lp.clickLoginButton();
    }

    @Then("user should login successfully")
    public void user_should_login_successfully() {

        String title =
        BaseClass.driver.getTitle();

        Assert.assertTrue(
        title.contains("My Account"));
    }

    @When("user clicks on Register option")
    public void user_clicks_on_register_option() {

        rp.clickRegister();
    }

    @When("user enters first name {string}")
    public void user_enters_first_name(
    String fname) {

        rp.enterFirstName(fname);
    }

    @When("user enters last name {string}")
    public void user_enters_last_name(
    String lname) {

        rp.enterLastName(lname);
    }

    @When("user enters register email {string}")
    public void user_enters_register_email(
    String email) {

        rp.enterEmail(email);
    }

    @When("user enters telephone {string}")
    public void user_enters_telephone(
    String phone) {

        rp.enterPhone(phone);
    }

    @When("user enters register password {string}")
    public void user_enters_register_password(
    String pass) {

        rp.enterPassword(pass);
    }

    @When("user confirms password {string}")
    public void user_confirms_password(
    String pass) {

        rp.enterConfirmPassword(pass);
    }

    @When("user selects privacy policy")
    public void user_selects_privacy_policy() {

        rp.clickPolicy();
    }

    @When("user clicks on Continue button")
    public void user_clicks_on_continue_button() {

        rp.clickContinue();
    }

    @Then("account should create successfully")
    public void account_should_create_successfully() {

        System.out.println(
        "Registration Successful");
    }

    @When("user searches product {string}")
    public void user_searches_product(
    String product) {

        sp.searchProduct(product);
    }

    @When("user clicks on search button")
    public void user_clicks_on_search_button() {

        sp.clickSearchButton();
    }

    @Then("searched product should display")
    public void searched_product_should_display() {

        System.out.println(
        "Product Displayed");
    }
}