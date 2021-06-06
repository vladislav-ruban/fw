import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/Features/SearchTest.feature"}, plugin = {"pretty"})
public class RunBddTests extends AbstractTestNGCucumberTests {
}