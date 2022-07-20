package page.objects.user;

import commons.UserBasePage;
import org.openqa.selenium.WebDriver;
import page.interfaces.user.AddFundsPageUI;

public class AddFundsPage extends UserBasePage {
    WebDriver driver;

    public AddFundsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToPayWithPaypalCheckbox(WebDriver driver) {
        waitForElementClickable(driver, AddFundsPageUI.PAY_WITH_PAYPAL_CHECKBOX);
        checkCheckboxOrRadio(driver, AddFundsPageUI.PAY_WITH_PAYPAL_CHECKBOX);
    }

    public PaymentPage clickToPayNowButton(WebDriver driver) {
        waitForElementClickable(driver, AddFundsPageUI.PAY_NOW_BUTTON);
        clickToElement(driver, AddFundsPageUI.PAY_NOW_BUTTON);
        return PageInitManager.getPageInitManager().getPaymentPage(driver);
    }
}
