package page.objects.user;

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
}
