package cucumber_runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // feature files run in alphabetical order, comment below lines if prefer running more than one feature file in the same time
//         features = { "src/test/java/features/user/002_login.feature", "src/test/java/features/user/001_sign_up.feature" },
        features = { "src/test/java/features/user/" },
        // need to specify path to Hooks class if it is stored in other package
        // than the same package as step_definitions
        glue =  { "step_definitions", "cucumber_runner" },
        monochrome = true,
        dryRun = false,
        plugin = {
                "pretty",
                "html:target/site/cucumber-report-default", "json:target/site/cucumber-report.json",
                "junit:target/site/cucumber-report.xml",
                "rerun:target/failed-testcases.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@SignUpAndLoginWithValidCredentials"
)
public class TestRunner {
}
