package step_definitions.user;

import cucumber_runner.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import page.objects.user.*;

public class MyProfileSteps {

    WebDriver driver;

    ProfilePage profilePage;
    DashboardPage dashboardPage;
    LoginPage loginPage;

    Logger log;

    public MyProfileSteps(Hooks hooks) {
        log = Logger.getLogger(MyProfileSteps.class);
        driver = hooks.driver;
        dashboardPage = PageInitManager.getPageInitManager().getDashboardPage(driver);
    }

    @When("click to MyProfile sidebar link")
    public void clickToMyProfileSidebarLink() {
        log.info("Pre Condition: Click to MyProfile sidebar link");
        profilePage = dashboardPage.clickToMyProfileSidebarLink(driver);
    }

    @Then("MyProfile page is displayed")
    public void isMyProfilePageDisplayed() {
        log.info("Pre Condition: MyProfile page is displayed");
    }

    @When("enter to {string} textbox with value = {string}")
    public void enterToTextboxWithValue(String fieldName, String value) {
        log.info("Enter to " + fieldName + " textbox with value = " + value);
        profilePage.enterToTextboxByNameAttribute(driver, fieldName, value);
    }

    @And("select country with value = {string} in dropdown list")
    public void selectCountryInDropdown(String country) {
        log.info("Select country = " + country + " in dropdown list");
        profilePage.selectCountryInDropdown(driver, country);
    }

    @And("click to UpdateProfile button")
    public void clickToUpdateProfileButton() {
        log.info("Click to UpdateProfile button");
        profilePage.clickToUpdateProfileButton(driver);
    }

    @Then("{string} message is displayed")
    public void isUpdateSuccessMessageDisplayed(String message) {
        log.info("Verify that message = '" + message + "' is displayed");
        Assert.assertTrue(profilePage.isUpdateSuccessMessageDisplayed(driver, message));
    }
}
