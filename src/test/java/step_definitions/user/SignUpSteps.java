package step_definitions.user;

import cucumber_runner.Hooks;
import helpers.DataFaker;
import helpers.LoggerHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import page.objects.user.HomePage;
import page.objects.user.LoginPage;
import page.objects.user.PageInitManager;
import page.objects.user.SignUpPage;
import share_context.Context;
import share_context.TestContext;

public class SignUpSteps {

    WebDriver driver;
    Logger log;
    TestContext testContext;

    HomePage homePage;
    SignUpPage signUpPage;
    LoginPage loginPage;

    public SignUpSteps(Hooks hooks, TestContext testContext) {
        this.driver = hooks.driver;
        this.testContext = testContext;
        log = LoggerHelper.getLogger(SignUpSteps.class);
        homePage = PageInitManager.getPageInitManager().getHomePage(driver);
    }

    @Given("SignUp page is displayed")
    public void signupPageIsDisplayed() {
        log.info("Redirect to SignUp page");
        signUpPage = homePage.clickToSignUpHeaderLink(driver);
    }

    @When("sign up new first name = {string}")
    public void signUpNewFirstName(String firstName) {
        log.info("Enter new first name = " + firstName);
        signUpPage.enterToFirstNameTextbox(driver, firstName);
    }

    @And("sign up new last name = {string}")
    public void signUpNewLastName(String lastName) {
        log.info("Enter new last name = " + lastName);
        signUpPage.enterToLastNameTextbox(driver, lastName);
    }

    @And("sign up new phone = {string}")
    public void signUpNewPhone(String phone) {
        log.info("Enter new phone = " + phone);
        signUpPage.enterToPhoneTextbox(driver, phone);
    }

    @And("signup new email")
    public void signupNewEmail() {
        String email = DataFaker.getDataFaker().generateEmail();
        testContext.getScenarioContext().setContext(Context.EMAIL, email);

        log.info("Enter new email = " + email);
        signUpPage.enterToEmailTextbox(driver, email);
    }

    @And("signup new password = {string}")
    public void signupNewPassword(String password) {
        testContext.getScenarioContext().setContext(Context.PASSWORD, password);

        log.info("Enter new password = " + password);
        signUpPage.enterToPasswordTextbox(driver, password);
    }

    @And("select account type = {string}")
    public void selectAccountType(String accountType) {
        log.info("Select account type = " + accountType);
        signUpPage.selectAccountType(driver, accountType);
    }

    @And("click to SignUp button")
    public void clickToSignUpButton() {
        log.info("Click to Sign Up button");
        signUpPage.clickToSignUpButton(driver);
    }

    @And("success message {string} is displayed")
    public void isRegisterSuccessMessageDisplayed(String message) {
        log.info("Verify that register success message is displayed");
        loginPage = PageInitManager.getPageInitManager().getLoginPage(driver);
        Assert.assertTrue(loginPage.isRegisterSuccessMessageDisplayed(driver, message));
    }
}
