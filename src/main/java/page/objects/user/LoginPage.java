package page.objects.user;

import commons.UserBasePage;
import org.openqa.selenium.WebDriver;
import page.interfaces.user.LoginPageUI;

public class LoginPage extends UserBasePage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToEmailTextbox(WebDriver driver, String email) {
        waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
    }

    public void enterToPasswordTextbox(WebDriver driver, String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public boolean isErrorMessageDisplayed(WebDriver driver, String message) {
        waitForElementVisible(driver, LoginPageUI.ERROR_MESSAGE_LABEL_DIV);
        String errorContent = getElementProperty(driver, LoginPageUI.ERROR_MESSAGE_LABEL_DIV, "innerText").trim();
        return isElementDisplayed(driver, LoginPageUI.ERROR_MESSAGE_LABEL_DIV) && errorContent.equals(message);
    }

    public void clickToLoginButton(WebDriver driver) {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
    }

    public DashboardPage login(WebDriver driver, String email, String password) {
        // enter email
        waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);

        // enter password
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);

        // click login button
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);

        return PageInitManager.getPageInitManager().getDashboardPage(driver);
    }
}
