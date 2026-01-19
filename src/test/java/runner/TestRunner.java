package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

 @RunWith(Cucumber.class)
 @CucumberOptions(
        features =  "src/test/resources/features/login.feature",
        glue = {"stepDefinitions", "hook","Types","objects"},
        plugin = {"pretty",
                  "html:target/cucumber-report.html",
                    "json:target/cucumber-report.json"},
        // tags = "(@login and @smoke) or (@registration and @smoke)",
         //dryRun = true,

        monochrome = true
                 )
public class TestRunner {

}
