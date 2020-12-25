import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources"},
        glue={"stepDefinitions","AppHookss"},
        plugin={"pretty",
        "json:target/myreports/reports.json",
        "timeline:test-output-thread"}


)


public class RunnerTest {
}
