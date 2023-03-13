package StepDefenition;

import Hooks.WebHooks;
import Ptoperties.GetProperties;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class TestSteps extends WebHooks {

    public static String charId;
    public static int lastEpisode;
    public static int episode;
    public static int LastCharacter;
    public static int lastCharacterNumber;
    public static String locationMorti;
    public static String speciesMorti;

    public static String locationBlim;
    public static String speciesBlim;
    public static String param1;
    public static String param2;

    static RequestSpecification help = new RequestSpecBuilder()
            .setBaseUri(GetProperties.getProperty("URL"))
            .build();

    @Step("Получение персонажа")
    @When("Получили локацию и расу персонажа id равен {string}")
    public static void getCharacter_get(String id) {

        Response getChar = given()
                .filter(new AllureRestAssured()).filter(new RequestLoggingFilter())
                .spec(help)
                .when()
                .get("/character/" + id)
                .then()
                .extract()
                .response();
        charId = new JSONObject(getChar.getBody().asString()).get("id").toString();
        locationMorti = new JSONObject(getChar.getBody().asString()).get("location").toString();
        speciesMorti = new JSONObject(getChar.getBody().asString()).get("species").toString();
    }

    @Step("Получение эпизода")
    @When("Получить lastEpisode")
    public static void getEpisode() {

        Response gettingEpisode = given()
                .filter(new AllureRestAssured()).filter(new RequestLoggingFilter())
                .spec(help)
                .when()
                .get("/character/" + charId)
                .then()
                .extract()
                .response();
        episode = (new JSONObject(gettingEpisode.getBody().asString()).getJSONArray("episode").length() - 1);
        lastEpisode = Integer.parseInt(new JSONObject(gettingEpisode.getBody().asString()).getJSONArray("episode").get(episode).toString().replaceAll("[^0-9]", ""));
    }

    @Step("Получение последнего персонажа")
    @When("Получить lastCharacterNumber")
    public static void lastChar() {

        Response gettingEpisode = given()
                .filter(new AllureRestAssured()).filter(new RequestLoggingFilter())
                .spec(help)
                .when()
                .get("/episode/" + lastEpisode)
                .then()
                .extract()
                .response();
        LastCharacter = new JSONObject(gettingEpisode.getBody().asString()).getJSONArray("characters").length() - 1;
        lastCharacterNumber = Integer.parseInt(new JSONObject(gettingEpisode.getBody().asString())
                .getJSONArray("characters")
                .get(LastCharacter).toString().replaceAll("[^0-9]", ""));
    }

    @Step("Получение расы и локации последнего персонажа")
    @When("Получить расу и локацию последнего персонажа")
    public static void local() {

        Response gettinglocal = given()
                .filter(new AllureRestAssured()).filter(new RequestLoggingFilter())
                .spec(help)
                .when()
                .get("/character/" + lastCharacterNumber)
                .then()
                .extract()
                .response();
        locationBlim = (new JSONObject(gettinglocal.getBody().asString()).get("location").toString());
        speciesBlim = (new JSONObject(gettinglocal.getBody().asString()).get("species").toString());
    }

    @Step("Проверка расы и локации последнего персонажа")
    @When("Проверить расу и локацию")
    public static void check() {
        Assertions.assertEquals(TestSteps.locationMorti, TestSteps.locationBlim);
        Assertions.assertEquals(TestSteps.speciesMorti, TestSteps.speciesBlim);
    }

    @Step("Изменение и добавление параметров")
    @When("Изменили и добавили")
    public static void PotatoVSTomato() throws IOException {

        RestAssured.baseURI = "https://reqres.in/";

        JSONObject requestBody = new JSONObject(Files.readAllBytes(Paths.get("src/test/resources/potato.json")));
        requestBody.put("name", "Tomato");
        requestBody.put("job", "Eat maket");
        Response updateTomato = given()
                .filter(new AllureRestAssured()).filter(new RequestLoggingFilter())
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .when()
                .put("/api/users/")
                .then()
                .statusCode(200)
                .extract().
                response();

        updateTomato.prettyPrint();
        param1 = new JSONObject(updateTomato.getBody().asString()).get("name").toString();
        param2 = new JSONObject(updateTomato.getBody().asString()).get("job").toString();
        Assertions.assertEquals(requestBody.get("name"), param1);
        Assertions.assertEquals(requestBody.get("job"), param2);

    }
}

