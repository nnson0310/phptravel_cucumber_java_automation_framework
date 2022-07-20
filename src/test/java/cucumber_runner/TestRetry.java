package cucumber_runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = { "@target/failed-testcases.txt" },
        glue = "step_definitions",
        monochrome = true,
        plugin = {
                "pretty",
                "html:target/site/cucumber-report-default", "json:target/site/cucumber-report.json",
                "junit:target/site/cucumber-report.xml",
                "rerun:target/failed-testcases.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class TestRetry {
}
