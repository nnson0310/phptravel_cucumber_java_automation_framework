package page.objects.user;

import commons.UserBasePage;
import org.openqa.selenium.WebDriver;
import page.interfaces.user.PaymentPageUI;

public class PaymentPage extends UserBasePage {
    WebDriver driver;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToPaypalButton(WebDriver driver) {
        waitForElementClickable(driver, PaymentPageUI.PAYPAL_BUTTON);
        clickToElement(driver, PaymentPageUI.PAYPAL_BUTTON);
    }

    public void switchToPaypalPopupWindow(WebDriver driver, String windowTitle) {
        switchWindowByTitle(driver, windowTitle);
    }
}
