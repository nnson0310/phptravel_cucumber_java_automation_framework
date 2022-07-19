package page.interfaces.user;

public interface ProfilePageUI {
    String UPDATE_PROFILE_BUTTON = "xpath=//button[contains(text(), 'Update Profile')]";
    String COUNTRY_DROPDOWN = "css=span.select2-container";
    String COUNTRY_DROPDOWN_ITEM = "xpath=//li[@class='select2-results__option' and contains(text(), '%s')]";
    String UPDATE_SUCCESS_LABEL_DIV = "xpath=//div[contains(@class, 'alert-success') and contains(., '%s')]";
}
