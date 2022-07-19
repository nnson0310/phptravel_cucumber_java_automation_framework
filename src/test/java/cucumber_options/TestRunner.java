package cucumber_options;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/user/",
        glue = "step_definitions",
        monochrome = true,
        plugin = {
                "pretty",
                "html:target/site/cucumber-report-default", "json:target/site/cucumber-report.json",
                "junit:target/site/cucumber-report.xml"
        },
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@UpdateProfile"
)
public class TestRunner {

}
