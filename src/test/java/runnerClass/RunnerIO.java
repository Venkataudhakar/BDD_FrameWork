package runnerClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = ".\\src\\test\\java\\featureFiles\\CreateContact.feature",
				   glue   = "stepDefinition",
				   tags   = "@CreateContact",
			 //	   plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"},
				   dryRun = false
				)
public class RunnerIO extends AbstractTestNGCucumberTests
{
	
}
