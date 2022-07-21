package commons;

import custom_exceptions.InvalidDomainException;
import enums.Domain;
import env_factory.CloudEnvFactory;
import env_factory.GridEnvFactory;
import env_factory.LocalEnvFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    private final Logger log = Logger.getLogger(BaseTest.class);
    private String appUrl;

    public WebDriver initBrowserDriver(String domainName) {
        // Run by Maven command line
        String browser = System.getProperty("browser") == null ? "chrome" : System.getProperty("browser").toLowerCase();
        String env = System.getProperty("env") == null ? "local" : System.getProperty("env").toLowerCase();

        System.out.println("Browser name run by command line = " + browser);
        System.out.println("Environment name run by command line = " + env);

        if (driver == null) {
            switch (env) {
                case "grid":
                    driver = new GridEnvFactory(browser).getWebDriver();
                    break;
                case "cloud":
                    driver = new CloudEnvFactory(browser).getWebDriver();
                    break;
                default:
                    driver = new LocalEnvFactory(browser).getWebDriver();
                    break;
            }
        }

        //identify what domain
        Domain domain = Domain.valueOf(domainName.toUpperCase());

        if (domain == Domain.USER) {
            driver.get(GlobalConstants.getGlobalConstants().getUserSiteUrl());
        } else if (domain == Domain.ADMIN) {
            driver.get(GlobalConstants.getGlobalConstants().getAdminSiteUrl());
        } else {
            throw new InvalidDomainException(domainName);
        }

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
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
