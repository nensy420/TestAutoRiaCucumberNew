package runers;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        plugin = {
        "html:target/cucumber-html-report",
        "json:target/cucumber.json",
        "pretty:target/cucumber.txt" ,
        "junit:target/cucumber-results.xml"},
        features="src/test/resources/features",glue="stepdef",
        tags = {"~@ignored"})

public class Runner extends AbstractTestNGCucumberTests {

}
