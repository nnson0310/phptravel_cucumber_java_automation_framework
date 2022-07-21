package page.objects.user;

import commons.UserBasePage;
import org.openqa.selenium.WebDriver;
import page.interfaces.user.LoginPageUI;
import page.interfaces.user.SignUpPageUI;

public class SignUpPage extends UserBasePage {
    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToEmailTextbox(WebDriver driver, String email) {
        waitForElementVisible(driver, SignUpPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, SignUpPageUI.EMAIL_TEXTBOX, email);
    }

    public void enterToPasswordTextbox(WebDriver driver, String password) {
        waitForElementVisible(driver, SignUpPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, SignUpPageUI.PASSWORD_TEXTBOX, password);
    }

    public void enterToFirstNameTextbox(WebDriver driver, String firstName) {
        waitForElementVisible(driver, SignUpPageUI.FIRST_NAME_TEXTBOX);
        sendKeyToElement(driver, SignUpPageUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void enterToLastNameTextbox(WebDriver driver, String lastName) {
        waitForElementVisible(driver, SignUpPageUI.LAST_NAME_TEXTBOX);
        sendKeyToElement(driver, SignUpPageUI.LAST_NAME_TEXTBOX, lastName);
    }

    public void enterToPhoneTextbox(WebDriver driver, String phone) {
        waitForElementVisible(driver, SignUpPageUI.PHONE_TEXTBOX);
        sendKeyToElement(driver, SignUpPageUI.PHONE_TEXTBOX, phone);
    }

    public void clickToSignUpButton(WebDriver driver) {
        waitForElementClickable(driver, SignUpPageUI.SIGN_UP_BUTTON);
        clickToElement(driver, SignUpPageUI.SIGN_UP_BUTTON);
    }

    public void selectAccountType(WebDriver driver, String accountType) {
        waitForElementClickable(driver, SignUpPageUI.ACCOUNT_TYPE_SELECT);
        clickToElement(driver, SignUpPageUI.ACCOUNT_TYPE_SELECT);

        waitForElementClickable(driver, SignUpPageUI.ACCOUNT_TYPE_SELECT_ITEM, accountType);
        clickToElement(driver, SignUpPageUI.ACCOUNT_TYPE_SELECT_ITEM, accountType);
    }
}
