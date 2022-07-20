package page.objects.user;

import commons.UserBasePage;
import org.openqa.selenium.WebDriver;
import page.interfaces.user.DashboardPageUI;

public class DashboardPage extends UserBasePage {
    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isWelcomeBackSidebarLabelDisplayed(WebDriver driver) {
        waitForElementVisible(driver, DashboardPageUI.WELCOME_BACK_SIDEBAR_LABEL_SPAN);
        return isElementDisplayed(driver, DashboardPageUI.WELCOME_BACK_SIDEBAR_LABEL_SPAN);
    }
}
