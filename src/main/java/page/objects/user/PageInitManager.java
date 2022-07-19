package page.objects.user;

import commons.UserBasePage;
import org.openqa.selenium.WebDriver;

public class PageInitManager {

    private static PageInitManager pageInitManager;

    public static PageInitManager getPageInitManager() {
        if (pageInitManager == null) {
            return new PageInitManager();
        }
        return pageInitManager;
    }

    public LoginPage getLoginPage(WebDriver driver) {
        return new LoginPage(driver);
    }

    public DashboardPage getDashboardPage(WebDriver driver) {
        return new DashboardPage(driver);
    }

    public ProfilePage getProfilePage(WebDriver driver) {
        return new ProfilePage(driver);
    }

    public HomePage getHomePage(WebDriver driver) {
        return new HomePage(driver);
    }
}
