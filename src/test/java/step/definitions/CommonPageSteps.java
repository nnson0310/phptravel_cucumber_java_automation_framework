package step.definitions;

import cucumber.options.Hooks;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import page.objects.CommonPage;
import page.objects.PageGeneratorManager;

public class CommonPageSteps {
    WebDriver driver;
    CommonPage commonPage;

    public CommonPageSteps() {
        driver = Hooks.openAndQuitBrowser();
        commonPage = PageGeneratorManager.getPageGeneratorManager().getCommonPageSteps(driver);
    }

}
