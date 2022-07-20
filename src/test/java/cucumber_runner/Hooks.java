package cucumber_runner;

import commons.BaseTest;
import helpers.FunctionHelper;
import helpers.LoggerHelper;
import helpers.ReadJson;
import inferfaces.Domain;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

public class Hooks {

    public WebDriver driver;
    private final Logger log = LoggerHelper.getLogger(Hooks.class);
    private BaseTest baseTest;

    public Hooks(BaseTest baseTest) {
        this.baseTest = baseTest;
    }

    @Before(order = 0)
    public void getWebDriver() {
        this.driver = baseTest.initBrowserDriver(Domain.userDomainIdentifier);
    }

    @Before(value = "not @Login", order = 1)
    public void logInToUserDashboard() throws IOException {
        String email = ReadJson.getReadJson().getValidUserCredentials().get("email");
        String password = ReadJson.getReadJson().getValidUserCredentials().get("password");

        log.info("Login to user dashboard with email = " + email + " and password = " + password);
        FunctionHelper.logInToUserDashboard(email, password, driver);
    }

    @After(order = 99999)
    public void close() {
        baseTest.closeBrowserAndKillDriver();
    }

    @AfterStep
    public void attachScreenshot(Scenario scenario) throws IOException
    {
        if(scenario.isFailed())
        {
            scenario.attach(FunctionHelper.getByteScreenshot(driver), "image/png", "image");
        }
    }
}
