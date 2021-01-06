import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


import org.junit.runner.RunWith;
import org.testng.annotations.*;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/parallel"},
        glue={"parallel"},

        plugin={"pretty",
                "json:target/myreports/reports.json",
                "timeline:test-output-thread"}


)

//comment if secnario level parallell execution is not needed via testng

public class ParallelRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel=true)
    public Object[][] scenarios()
    {
        return super.scenarios();
    }

}
