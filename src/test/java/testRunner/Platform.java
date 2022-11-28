package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features/OnDemandTab.feature",
glue = {"stepDefinition"},
        monochrome = true,
        plugin = { "pretty" ,"html:src/Reports/Platform-reports"})
public class Platform extends AbstractTestNGCucumberTests {
}
