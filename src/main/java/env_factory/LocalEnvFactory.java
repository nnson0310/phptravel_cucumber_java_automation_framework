package env_factory;

import browser_factory.*;
import enums.Browser;
import org.openqa.selenium.WebDriver;

public class LocalEnvFactory {

    private final String browser;

    public LocalEnvFactory(String browser) {
        this.browser = browser;
    }

    public WebDriver getWebDriver() {
        Browser browserName = Browser.valueOf(browser.toUpperCase());

        WebDriver driver;
        switch (browserName) {
            case H_CHROME:
                driver = new HChromeDriverFactory().getBrowserDriver();
                break;
            case H_FIREFOX:
                driver = new HFirefoxDriverFactory().getBrowserDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriverFactory().getBrowserDriver();
                break;
            case EDGE:
                driver = new EdgeDriverFactory().getBrowserDriver();
                break;
            case OPERA:
                driver = new OperaDriverFactory().getBrowserDriver();
                break;
            case SAFARI:
                driver = new SafariDriverFactory().getBrowserDriver();
                break;
            case CHROME:
                driver = new ChromeDriverFactory().getBrowserDriver();
                break;
            default:
                throw new RuntimeException(browser + " is invalid");
        }
        return driver;
    }
}
