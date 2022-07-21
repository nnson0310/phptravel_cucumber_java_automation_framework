package browser_factory;

import custom_exceptions.BrowserNotSupportedException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import static org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS;

public class EdgeDriverFactory implements DriverFactory {

    @Override
    public WebDriver getBrowserDriver() {
        if(!IS_OS_WINDOWS) {
            throw new BrowserNotSupportedException("Edge browser");
        }
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }
}
