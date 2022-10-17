package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
	features = "D://User//Eclipse-workspace//mopCommerce_V001_Cucumber//Feature/",
	glue = "stepDefination",
	dryRun = false,
	monochrome = true,
	plugin = {"pretty","html:test-output"},
	tags = "@sanity"
)
public class TestRun {

}
