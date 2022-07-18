package step_definitions.user;

import cucumber_options.Hooks;
import helpers.LoggerHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import page.objects.user.LoginPage;
import page.objects.user.PageInitManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Login {

    WebDriver driver;
    LoginPage loginPage;
    Logger log = LoggerHelper.getLogger(Login.class);

    @Given("visit to {string}")
    public void navigateToLoginPage(String url) {
        log.info("Navigate to user login page with url = " + url);
        driver = Hooks.openAndQuitBrowser(url);
        loginPage = PageInitManager.getPageInitManager().getLoginPage(driver);
    }

    @When("enter email with value = {string}")
    public void enterToEmailTextbox(String email) {
        log.info("Enter to email textbox with email = " + email);
        loginPage.enterToEmailTextbox(email);
    }

    @And("enter password with value = {string}")
    public void enterToPasswordTextbox(String password) {
        log.info("Enter to password textbox with password = " + password);
        loginPage.enterToPasswordTextbox(password);
    }

    @And("click to login button")
    public void clickToLoginButton() {
        log.info("Click login button");
        loginPage.clickToLoginButton();
    }

    @Then("verify that error message = {string} is displayed")
    public void isErrorMessageDisplayed(String message) {
        log.info("Verify that error message = '" + message + "' is displayed");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(message));
    }

    @When("enter credentials")
    public void enterCredentials(DataTable credentials) {
        for(Map<String, String> credential : credentials.asMaps(String.class, String.class)) {
            log.info("Enter email = " + credential.get("email"));
            loginPage.enterToEmailTextbox(credential.get("email"));

            log.info("Enter password = " + credential.get("password"));
            loginPage.enterToPasswordTextbox(credential.get("password"));
        }
    }
}
