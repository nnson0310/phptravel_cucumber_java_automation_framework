package browser_factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HChromeDriverFactory implements DriverFactory {

    @Override
    public WebDriver getBrowserDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions hChromeOptions = new ChromeOptions();
        hChromeOptions.addArguments("headless");
        hChromeOptions.addArguments("window-size=1920x1080");
        return new ChromeDriver(hChromeOptions);
    }
}
