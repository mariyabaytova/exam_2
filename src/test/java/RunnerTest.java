import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        plugin = {"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"},
        glue = {"StepDefenition", "Hooks"},
        tags = "@TEST"
)
public class RunnerTest {
    @BeforeClass
    public static void before() {

    }
}