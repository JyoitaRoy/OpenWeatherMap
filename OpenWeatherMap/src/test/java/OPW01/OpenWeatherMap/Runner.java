package OPW01.OpenWeatherMap;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"featurefiles/weather.feature"}
		,glue= {"StepDefinition"}
		,tags= "@tag"
		)
 
public class Runner extends AbstractTestNGCucumberTests{

}
