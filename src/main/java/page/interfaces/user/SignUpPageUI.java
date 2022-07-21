package page.interfaces.user;

public interface SignUpPageUI {
    String FIRST_NAME_TEXTBOX = "css=input[name='first_name']";
    String LAST_NAME_TEXTBOX = "css=input[name='last_name']";
    String EMAIL_TEXTBOX = "css=input[name='email']";
    String PASSWORD_TEXTBOX = "css=input[name='password']";
    String PHONE_TEXTBOX = "css=input[name='phone']";
    String SIGN_UP_BUTTON = "xpath=//span[text()='Signup']//parent::button";
    String ACCOUNT_TYPE_SELECT = "xpath=//select[@id='account_type']//following-sibling::span";
    String ACCOUNT_TYPE_SELECT_ITEM = "xpath=//ul[@id='select2-account_type-results']//li[text()='%s']";
}
