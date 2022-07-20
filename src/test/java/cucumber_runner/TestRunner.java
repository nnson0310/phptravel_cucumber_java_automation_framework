package cucumber_runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/user/",
        // specify Hooks class if it is stored in other package
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
        tags = "@AddFunds"
)
public class TestRunner {
}
