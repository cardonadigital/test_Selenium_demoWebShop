package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        features = {"src/test/resources/features/register.feature"},
        glue = "stepdefinitions",
        plugin = {"pretty", "html:target/cucumber-reports-register.html"}
)
public class RegisterTestRunner {
}
