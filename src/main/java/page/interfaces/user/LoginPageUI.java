package page.interfaces.user;

public class LoginPageUI {
    public static final String EMAIL_TEXTBOX = "xpath=//label[text()='Email']//following-sibling::div//input[@name='email']";
    public static final String PASSWORD_TEXTBOX = "xpath=//label[text()='Password']//following-sibling::div//input[@name='password']";
    public static final String ERROR_MESSAGE_LABEL_DIV = "css=div.message div.failed";
    public static final String LOGIN_BUTTON = "xpath=//span[text()='Login']//parent::button";
}
