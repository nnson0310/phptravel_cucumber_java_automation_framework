package page.objects.user;

import commons.UserBasePage;
import org.openqa.selenium.WebDriver;
import page.interfaces.user.HomePageUI;

public class HomePage extends UserBasePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
}
