package page.objects.user;

import commons.UserBasedPage;
import org.openqa.selenium.WebDriver;
import page.interfaces.user.LoginPageUI;

public class LoginPage extends UserBasedPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToEmailTextbox(String email) {
        waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public boolean isErrorMessageDisplayed(String message) {
        waitForElementVisible(driver, LoginPageUI.ERROR_MESSAGE_LABEL_DIV);
        String errorContent = getElementProperty(driver, LoginPageUI.ERROR_MESSAGE_LABEL_DIV, "innerText").trim();
        return isElementDisplayed(driver, LoginPageUI.ERROR_MESSAGE_LABEL_DIV) && errorContent.equals(message);
    }

    public void clickToLoginButton() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
    }
}
