package page.interfaces.user;

public interface LoginPageUI {
    String EMAIL_TEXTBOX = "xpath=//label[text()='Email']//following-sibling::div//input[@name='email']";
    String PASSWORD_TEXTBOX = "xpath=//label[text()='Password']//following-sibling::div//input[@name='password']";
    String ERROR_MESSAGE_LABEL_DIV = "css=div.message div.failed";
    String SIGNUP_SUCCESS_MESSAGE_LABEL_DIV = "xpath=//div[contains(@class, 'signup') and contains(., '%s')]";
    String LOGIN_BUTTON = "xpath=//span[text()='Login']//parent::button";
}
