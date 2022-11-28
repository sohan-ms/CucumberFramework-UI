package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features/Regression.feature",
glue = {"stepDefinition"},
        monochrome = true,
        plugin = { "pretty","html:src/Reports/Ondemand-report" })
public class OnDemandRegression extends AbstractTestNGCucumberTests {
}
