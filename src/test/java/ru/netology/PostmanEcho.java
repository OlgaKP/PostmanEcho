package ru.netology;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class PostmanEcho {
    @Test
    void shouldPostRequest(){
        // Given - When - Then
        // Предусловия
        given()
            .baseUri("https://postman-echo.com")
            .body("{ \"phone\": \"8 (800)-000-12-34\" }") // отправляемые данные (заголовки и query можно выставлять аналогично)
        // Выполняемые действия
        .when()
            .post("/post")
        // Проверки
        .then()
            .statusCode(200)
            .body("data", equalTo("{ \"phone\": \"8 (800)-000-12-33\" }"))
        ;
    }
}
