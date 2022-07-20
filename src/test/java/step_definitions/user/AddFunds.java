package step_definitions.user;

import commons.BaseTest;
import cucumber_runner.Hooks;
import helpers.LoggerHelper;
import inferfaces.Domain;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page.objects.user.*;

public class AddFunds {

    WebDriver driver;

    DashboardPage dashboardPage;
    LoginPage loginPage;
    AddFundsPage addFundsPage;
    PaymentPage paymentPage;

    Logger log;

    public AddFunds(Hooks hooks) {
        log = LoggerHelper.getLogger(AddFunds.class);
        driver = hooks.driver;
        dashboardPage = PageInitManager.getPageInitManager().getDashboardPage(driver);
    }

    @When("click to AddFunds sidebar link")
    public void clickToAddFundsSidebarLink() {
        log.info("Pre Condition: Click to AddFunds sidebar link");
        addFundsPage = dashboardPage.clickToAddFundsSidebarLink(driver);
    }

    @Then("AddFunds page is displayed")
    public void isAddFundsPageDisplayed() {
        log.info("Pre Condition: AddFunds page is displayed");
    }

    @When("click to Pay With Paypal checkbox")
    public void clickToPayWithPaypalCheckbox() {
        log.info("Click to pay with paypal checkbox");
        addFundsPage.clickToPayWithPaypalCheckbox(driver);
    }

    @And("click to Pay Now button")
    public void clickToPayNowButton() {
        log.info("Click to pay now button");
        paymentPage = addFundsPage.clickToPayNowButton(driver);
    }

    @And("redirect to payment page")
    public void redirectToPaymentPage() {
        log.info("redirect to payment page");
    }

    @And("click to Paypal button")
    public void clickToPaypalButton() {
        log.info("Click to paypal button");
        paymentPage.clickToPaypalButton(driver);
    }

    @And("switch to paypal popup window")
    public void switchToPaypalPopupWindow() {
        log.info("Switch to paypal popup window");
        String windowTitle = "Log in to your PayPal account";
        paymentPage.switchToPaypalPopupWindow(driver, windowTitle);
    }
}
