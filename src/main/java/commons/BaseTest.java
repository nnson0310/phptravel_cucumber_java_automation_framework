package commons;

import custom_exceptions.InvalidDomainException;
import enums.Domain;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    private final Logger log = Logger.getLogger(BaseTest.class);

    public WebDriver initBrowserDriver(String domainName) {
        // Run by Maven command line
        String browser = System.getProperty("BROWSER");
        System.out.println("Browser name run by command line = " + browser);

        //identify what domain
        Domain domain = Domain.valueOf(domainName.toUpperCase());

        if (driver == null) {
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

            // get correct url corresponding to domain name
            if (domain == Domain.USER) {
                driver.get(GlobalConstants.getGlobalConstants().getUserSiteUrl());
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

    public void closeBrowserAndKillDriver() {
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
}
