package browser_factory;

import custom_exceptions.BrowserNotSupportedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import static org.apache.commons.lang3.SystemUtils.IS_OS_MAC;

public class SafariDriverFactory implements DriverFactory {
    public WebDriver getBrowserDriver() {
        if(!IS_OS_MAC) {
            throw new BrowserNotSupportedException("Safari browser");
        }
        return new SafariDriver();
    }
}
