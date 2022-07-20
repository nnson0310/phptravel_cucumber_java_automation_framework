package step_definitions.user;

import cucumber_runner.Hooks;
import inferfaces.Domain;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import page.objects.user.DashboardPage;
import page.objects.user.HomePage;
import page.objects.user.LoginPage;
import page.objects.user.PageInitManager;
import java.util.Map;

public class Login {

    WebDriver driver;

    HomePage homePage;
    LoginPage loginPage;
    DashboardPage dashboardPage;

    Logger log;

    public Login() {
        log = Logger.getLogger(Login.class);
        driver = Hooks.initBrowserDriver(Domain.userDomainIdentifier);
    }

    @Given("homepage is displayed")
    public void isHomePageDisplayed() {
        log.info("Home page is displayed");
        homePage = PageInitManager.getPageInitManager().getHomePage(driver);
    }

    @When("click to login header link")
    public void clickToLoginHeaderLink() {
        log.info("Click to login header link");
        homePage.clickToLoginHeaderLink(driver);
    }

    @Given("login page is displayed")
    public void isLoginPageDisplayed() {
        log.info("Click to login header link");
        loginPage = PageInitManager.getPageInitManager().getLoginPage(driver);
    }

    @When("enter email = {string}")
    public void enterToEmailTextbox(String email) {
        log.info("Enter to email textbox with email = " + email);
        loginPage.enterToEmailTextbox(driver, email);
    }

    @And("enter password = {string}")
    public void enterToPasswordTextbox(String password) {
        log.info("Enter to password textbox with password = " + password);
        loginPage.enterToPasswordTextbox(driver, password);
    }

    @And("click to login button")
    public void clickToLoginButton() {
        log.info("Click login button");
        loginPage.clickToLoginButton(driver);
    }

    @Then("error message {string} is displayed")
    public void isErrorMessageDisplayed(String message) {
        log.info("Verify that error message = '" + message + "' is displayed");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(driver, message));
    }

    @When("enter credentials")
    public void enterCredentials(DataTable credentials) {
        for(Map<String, String> credential : credentials.asMaps(String.class, String.class)) {
            log.info("Enter email = " + credential.get("email"));
            loginPage.enterToEmailTextbox(driver, credential.get("email"));

            log.info("Enter password = " + credential.get("password"));
            loginPage.enterToPasswordTextbox(driver, credential.get("password"));
        }
    }

    @Then("redirect to Dashboard page")
    public void redirectToDashboardPage() {
        dashboardPage = PageInitManager.getPageInitManager().getDashboardPage(driver);

        log.info("verify that 'welcome back' sidebar label is displayed");
        Assert.assertTrue(dashboardPage.isWelcomeBackSidebarLabelDisplayed());
    }
}
