package Jira;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class Auth {
    public static SelenideElement loginInput = $x("//input[@name='os_username']").as("Ввод логина");
    public static SelenideElement passwordInput = $x("//input[@name='os_password']").as("Ввод пароля");
    public static SelenideElement rememberMe = $x("//label[@id='remembermelabel']").as("Запомнить меня");
    public static  SelenideElement entranceButton = $x("//input[@value='Войти']").as("Войти");
    public static  SelenideElement entrance = $x("//div[@class='aui-page-header-main']//h1[text()='System Dashboard']").as("System Dashboard");


    @Step
    //@DisplayName("Проходит авторизация")
    public void AuthorizationTest() {

        loginInput.shouldBe(Condition.visible, Duration.ofSeconds(20));
        loginInput.setValue("mbaitova");
        // loginInput.sendKeys("mbaitova");
        passwordInput.shouldBe(Condition.visible, Duration.ofSeconds(20));
        passwordInput.setValue("Qwerty123");
        rememberMe.click();
        entranceButton.click();

        String s = entrance.getText();
        Assert.assertEquals("System Dashboard", s);
    }

}

