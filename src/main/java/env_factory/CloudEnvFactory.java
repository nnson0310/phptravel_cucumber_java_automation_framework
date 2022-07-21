package env_factory;

import commons.GlobalConstants;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class CloudEnvFactory {

    WebDriver driver;
    String browser;
    CloudProperties systemProperties;

    public CloudEnvFactory(String browser) {
        this.browser = browser;
        systemProperties = ConfigFactory.create(CloudProperties.class);
    }

    public WebDriver getWebDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("os", systemProperties.os());
        capabilities.setCapability("os_version", systemProperties.osVersion());
        capabilities.setCapability("browser", browser);
        capabilities.setCapability("browser_version", systemProperties.browserVersion());
        capabilities.setCapability("project", systemProperties.projectName());
        capabilities.setCapability("build", systemProperties.buildVersion());
        capabilities.setCapability("name", "Run on Browser Stack with os = " + systemProperties.os() + " and browser = " + browser);

        //get cloud testing url
        // Uncomment below lines you prefer setting cloud credentials through batch file
//        final String cloudUsername = System.getenv("BROWSERSTACK_USERNAME");
//        final String cloudAutomateKey = System.getenv("BROWSERSTACK_AUTOMATE_KEY");
        final String cloudUrl = "https://" + systemProperties.cloudUsername() + ":" + systemProperties.cloudAutomateKey() + "@hub-cloud.browserstack.com/wd/hub";

        try {
            driver = new RemoteWebDriver(new URL(cloudUrl), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
