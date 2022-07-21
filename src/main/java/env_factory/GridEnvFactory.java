package env_factory;

import enums.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class GridEnvFactory {

    WebDriver driver;
    private final String browser;
    private final String ipAddress;
    private final String port;

    public GridEnvFactory(String browser) {
        this.browser = browser;
        CloudProperties cloudProperties = ConfigFactory.create(CloudProperties.class);
        ipAddress = cloudProperties.ipAddress();
        port = cloudProperties.port();
    }

    public WebDriver getWebDriver() {
        DesiredCapabilities capabilities = null;
        Browser browserName = Browser.valueOf(browser.toUpperCase());

        if (browserName == Browser.FIREFOX) {
            WebDriverManager.firefoxdriver().setup();
            capabilities = DesiredCapabilities.firefox();
            // Comment below code if running with docker compose
            capabilities.setAcceptInsecureCerts(true);
            capabilities.setBrowserName(String.valueOf(Browser.FIREFOX).toLowerCase());
            capabilities.setPlatform(Platform.ANY);
            capabilities.setVersion("latest");

            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.merge(capabilities);
        } else if (browserName == Browser.CHROME) {
            WebDriverManager.chromedriver().setup();

            capabilities = DesiredCapabilities.chrome();
            // Comment below code if running with docker compose
            capabilities.setAcceptInsecureCerts(true);
            capabilities.setBrowserName(String.valueOf(Browser.CHROME).toLowerCase());
            capabilities.setPlatform(Platform.ANY);

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.merge(capabilities);
        } else if (browserName == Browser.OPERA) {
            WebDriverManager.operadriver().setup();

            capabilities = DesiredCapabilities.operaBlink();
            capabilities.setAcceptInsecureCerts(true);
            capabilities.setBrowserName(String.valueOf(Browser.OPERA).toLowerCase());
            capabilities.setPlatform(Platform.ANY);

            OperaOptions operaOptions = new OperaOptions();
            operaOptions.merge(capabilities);
        } else {
            throw new RuntimeException("Browser name is invalid");
        }

        try {
            driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/wd/hub", ipAddress, port)), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
