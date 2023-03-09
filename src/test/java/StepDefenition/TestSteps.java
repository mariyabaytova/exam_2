package StepDefenition;

//import io.cucumber.java.ru.Дано;
import Hooks.WebHooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
//import org.junit.runner.RunWith;
import io.cucumber.java.PendingException;
import io.qameta.allure.Step;

public class TestSteps extends WebHooks {
    public static int Aa;
    public static int Bb;
    public static int sum = Aa + Bb;
    public static int summa = Aa + Bb;

    @Step("Пользователь вводит числа")
    @When("Пользователь вводит {int} и {int}")
    public void пользователь_вводит(Integer Bb, Integer Aa) {
        this.Bb = Bb;
        this.Aa = Aa;
    }
    @Step("Получение суммы")
    @Then("Получить сумму {int}")
    public void получить_сумму(Integer summa) {
        this.summa = summa;

    }

}

