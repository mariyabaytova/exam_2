package Hooks;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class WebHooks {
    @BeforeEach
    public void allures(){
        String listenerName = "AllureSelenide";

        new AllureSelenide().
                screenshots(true).
                savePageSource(false);

    }

    @AfterEach
    public void driverClose() {
       // new AllureHelper().afterTestExecution();
        WebDriverRunner.closeWebDriver();
    }
}
