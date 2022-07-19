package commons;

import org.openqa.selenium.WebDriver;
import page.interfaces.user.CommonUI;
import page.interfaces.user.HomePageUI;
import page.objects.user.HomePage;
import page.objects.user.LoginPage;
import page.objects.user.PageInitManager;

public class UserBasePage extends BasePage {

    public LoginPage clickToLoginHeaderLink(WebDriver driver) {
        waitForElementClickable(driver, HomePageUI.LOGIN_HEADER_BUTTON);
        clickToElement(driver, HomePageUI.LOGIN_HEADER_BUTTON);
        return PageInitManager.getPageInitManager().getLoginPage(driver);
    }

    public void clickToMyProfileSidebarLink(WebDriver driver) {
        waitForElementClickable(driver, CommonUI.MY_PROFILE_SIDEBAR_LINK);
        clickToElement(driver, CommonUI.MY_PROFILE_SIDEBAR_LINK);
    }

    public void enterToTextboxByNameAttribute(WebDriver driver, String fieldName, String value) {
        waitForElementVisible(driver, CommonUI.DYNAMIC_TEXTBOX_BY_NAME_ATTRIBUTE, fieldName);
        scrollToElement(driver, CommonUI.DYNAMIC_TEXTBOX_BY_NAME_ATTRIBUTE, fieldName);
        sendKeyToElement(driver, CommonUI.DYNAMIC_TEXTBOX_BY_NAME_ATTRIBUTE, value, fieldName);
    }

    public HomePage redirectToHomePage(WebDriver driver) {
        redirectToPage(driver, GlobalConstants.getGlobalConstants().getUserSiteUrl());
        return PageInitManager.getPageInitManager().getHomePage(driver);
    }
}
