package StepDefenition;

//import io.cucumber.java.ru.Дано;
import Hooks.WebHooks;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
//import org.junit.runner.RunWith;
import io.cucumber.java.PendingException;
import io.qameta.allure.Step;

public class TestSteps extends WebHooks {
    public static int Aa;
    public static int Bb;
    public static int sum;

    @Step("Пользователь вводит числа")
    @Когда("Пользователь вводит {int} и {int}")
    public void пользователь_вводит(Integer Bb, Integer Aa) {
        this.Bb = Bb;
        this.Aa = Aa;
    }
    @Step("Получение суммы")
    @Тогда("Получить сумму")
    public void получить_сумму() {
        sum = Aa + Bb;
    }
    @Step("Получение результата")
    @Тогда("Получить результат")
    public void получить_результат() {
         System.out.println(sum);
    }
}

