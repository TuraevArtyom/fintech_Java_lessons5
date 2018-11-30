package ru.lessons;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.lessons.request.RequestModel;

import java.util.List;
import java.util.stream.Stream;

import static io.restassured.RestAssured.given;

public class DeleteSubscriptionTest {

    @ParameterizedTest
    @MethodSource("getIdSubscription")
    public void deleteSubscriptionTest(String subscriptionId){
        given().spec(RequestModel.getRequestSpecification())
                .pathParam("siebel_id", "a.turaev")
                .pathParam("subscription_id", subscriptionId)
                .queryParam("request_id", "6f994192-e701-11e8-9f32-f2801f1b9fd1")
                .queryParam("system_code", "T-API")
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .when()
                .delete("/contacts/{siebel_id}/subscriptions/{subscription_id}")
                .then()
                .assertThat()
                .statusCode(200);
    }

    static Stream<String> getIdSubscription(){
        String idSubscription = given().spec(RequestModel.getRequestSpecification())
                .pathParam("siebel_id", "a.turaev")
                .queryParam("request_id", "6f994192-e701-11e8-9f32-f2801f1b9fd1")
                .queryParam("system_code", "T-API")
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .body(InputData.createJSONObjectGetId())
                .when()
                .post("/contacts/{siebel_id}/subscriptions")
                .then()
                .specification(RequestModel.getResponseSpecification())
                .assertThat()
                .statusCode(200)
                .extract()
                .path("id");
        return Stream.of(idSubscription);
    }

    @Test
    public void deleteFailSubscriptionTest(){
        given().spec(RequestModel.getRequestSpecification())
                .pathParam("siebel_id", "a.turaev")
                .queryParam("request_id", "6f994192-e701-11e8-9f32-f2801f1b9fd1")
                .queryParam("system_code", "T-API")
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .when()
                .delete("/contacts/{siebel_id}/subscriptions/{subscription_id}")
                .then()
                .assertThat()
                .statusCode(404);
    }

    @Test
    public void deleteFailIdSubscriptionTest(){
        given().spec(RequestModel.getRequestSpecification())
                .pathParam("siebel_id", "a.turaev")
                .pathParam("subscription_id", "3654")
                .queryParam("request_id", "6f994192-e701-11e8-9f32-f2801f1b9fd1")
                .queryParam("system_code", "T-API")
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .when()
                .delete("/contacts/{siebel_id}/subscriptions/{subscription_id}")
                .then()
                .assertThat()
                .statusCode(500);
    }

    public static void deleteSubscription (String subscriptionId){
        given().spec(RequestModel.getRequestSpecification())
                .queryParam("request_id","6f994192-e701-11e8-9f32-f2801f1b9fd1")
                .queryParam("system_code","T-API")
                .pathParam("subscription_id",subscriptionId)
                .delete("/subscriptions/{subscription_id}");

    }

    public static void deleteAllSubscriptions () {
        List<String> idSubs = given().spec(RequestModel.getRequestSpecification())
                .queryParam("request_id","6f994192-e701-11e8-9f32-f2801f1b9fd1")
                .queryParam("system_code","T-API")
                .when()
                .get("/subscriptions")
                .then()
                .extract()
                .jsonPath()
                .getList("id",String.class);
        for (String idCode1: idSubs) {
            deleteSubscription(idCode1);
        }
    }
}


