package page.objects.user;

import commons.UserBasePage;
import org.openqa.selenium.WebDriver;
import page.interfaces.user.ProfilePageUI;

public class ProfilePage extends UserBasePage {

    WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectCountryInDropdown(WebDriver driver, String country) {
        waitForElementClickable(driver, ProfilePageUI.COUNTRY_DROPDOWN);
        clickToElement(driver, ProfilePageUI.COUNTRY_DROPDOWN);

        waitForElementClickable(driver, ProfilePageUI.COUNTRY_DROPDOWN_ITEM, country);
        scrollToElement(driver, ProfilePageUI.COUNTRY_DROPDOWN_ITEM, country);
        clickToElement(driver, ProfilePageUI.COUNTRY_DROPDOWN_ITEM, country);
    }

    public void clickToUpdateProfileButton(WebDriver driver) {
        waitForElementClickable(driver, ProfilePageUI.UPDATE_PROFILE_BUTTON);
        clickToElement(driver, ProfilePageUI.UPDATE_PROFILE_BUTTON);
    }

    public boolean isUpdateSuccessMessageDisplayed(WebDriver driver, String message) {
        waitForElementVisible(driver, ProfilePageUI.UPDATE_SUCCESS_LABEL_DIV, message);
        return isElementDisplayed(driver, ProfilePageUI.UPDATE_SUCCESS_LABEL_DIV, message);
    }
}
