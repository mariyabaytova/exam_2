import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.BeforeClass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"StepDefenition"},
        tags = "@TEST"

)
//@Tag("Test")
//@DisplayName("ТК 01-03. Получение суммы чисел")
public class RunnerTest {
    @BeforeClass
    public static void before() {
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().
                        screenshots(true).
                        savePageSource(false)
        );
    }

}