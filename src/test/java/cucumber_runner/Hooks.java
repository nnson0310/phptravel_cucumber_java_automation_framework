package cucumber_runner;

import commons.GlobalConstants;
import custom_exceptions.InvalidDomainException;
import enums.Domain;
import helpers.FunctionHelper;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import page.objects.user.DashboardPage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Hooks {
    private static WebDriver driver;
    private static final Logger log = Logger.getLogger(Hooks.class);

    @Before(order = 0)
    public static WebDriver initBrowserDriver(String domainName) {
        // Run by Maven command line
        String browser = System.getProperty("BROWSER");
        System.out.println("Browser name run by command line = " + browser);

        //identify what domain
        Domain domain = Domain.valueOf(domainName.toUpperCase());

        if (driver == null) {
            try {
                if (browser == null) {
                    browser = "firefox";
                }
                switch (browser) {
                    case "h_chrome":
                        WebDriverManager.chromedriver().setup();
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.addArguments("headless");
                        chromeOptions.addArguments("window-size=1920x1080");
                        driver = new ChromeDriver(chromeOptions);
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
                        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                        driver = new FirefoxDriver();
                        break;
                    case "h_firefox":
                        WebDriverManager.firefoxdriver().setup();
                        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
                        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        firefoxOptions.setHeadless(true);
                        driver = new FirefoxDriver(firefoxOptions);
                        break;
                    case "edge":
                        WebDriverManager.edgedriver().setup();
                        driver = new EdgeDriver();
                        break;
                    default:
                        WebDriverManager.operadriver().setup();
                        driver = new OperaDriver();
                }
            } finally {
                Runtime.getRuntime().addShutdownHook(new Thread(new CloseBrowserAndKillDriver()));
            }

            // get correct url corresponding to domain name
            if (domain == Domain.USER) {
                driver.get(GlobalConstants.getGlobalConstants().getUserSiteUrl());
                logInToUserDashboard();
            } else if (domain == Domain.ADMIN) {
                driver.get(GlobalConstants.getGlobalConstants().getAdminSiteUrl());
            } else {
                throw new InvalidDomainException(domainName);
            }
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    // Comment below line if running only @Login feature
    public static DashboardPage logInToUserDashboard() {
        String email = "user@phptravels.com";
        String password = "demouser";

        log.info("Login to user dashboard with email = " + email + " and password = " + password);
        return FunctionHelper.logInToUserDashboard(email, password, driver);
    }

    @After(order = 99999)
    public static void close() {

        try {
            if (driver != null) {
                log.info("------------- Closed the browser and delete all cookies-------------");
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (UnreachableBrowserException e) {
            log.info("------------- Can not close the browser -------------");
            e.printStackTrace();
        }
    }

    @AfterStep
    public void attachScreenshot(Scenario scenario) throws IOException
    {
        if(scenario.isFailed())
        {
            scenario.attach(FunctionHelper.getByteScreenshot(driver), "image/png", "image");
        }
    }

    public static class CloseBrowserAndKillDriver implements Runnable {
        @Override
        public void run() {
            close();
        }
    }
}
