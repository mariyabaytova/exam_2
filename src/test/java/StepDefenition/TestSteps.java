package StepDefenition;

//import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
//import org.junit.runner.RunWith;
import io.cucumber.java.PendingException;

public class TestSteps {
    public static int Aa;
    public static int Bb;
    public static int sum;

    @Когда("Пользователь вводит {int} и {int}")
    public void пользователь_вводит(Integer Bb, Integer Aa) {
        this.Bb = Bb;
        this.Aa = Aa;
    }
    @Тогда("Получить сумму")
    public void получить_сумму() {
        sum = Aa + Bb;
    }
    @Тогда("Получить результат")
    public void получить_результат() {
         System.out.println(sum);
    }
}

