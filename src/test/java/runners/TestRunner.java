package runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
@CucumberOptions(features = "src/test/resources/features"
        ,glue = "steps",publish = true,plugin = {"pretty","html:target/sprint_2-reports.html","json:target/searchbar_cucumber-reports.json"},
        monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {
    @DataProvider(parallel = true)//,tags="@smoke"
    public Object[][] scenarios(){
        return super.scenarios();  }}
