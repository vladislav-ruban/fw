import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/Features"}, plugin = {"pretty"})
public class RunBddTests extends AbstractTestNGCucumberTests {
}