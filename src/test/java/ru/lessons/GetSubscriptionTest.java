package ru.lessons;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import ru.lessons.request.RequestModel;

import static io.restassured.RestAssured.given;

public class GetSubscriptionTest {

    @Test
    public void getSubscriptionListTest(){
        given().spec(RequestModel.getRequestSpecification())
                .pathParam("siebel_id", "a.turaev")
                .queryParam("request_id", "6f994192-e701-11e8-9f32-f2801f1b9fd1")
                .queryParam("system_code", "T-API")
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .when()
                .get("/contacts/{siebel_id}/subscriptions")
                .then()
                .specification(RequestModel.getResponseSpecification())
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void getNoParamsSubscriptionsTest(){
        given().spec(RequestModel.getRequestSpecification())
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .get("/subscriptions")
                .then()
                .specification(RequestModel.getResponseSpecification())
                .assertThat()
                .statusCode(400)
                .body("error", Matchers.equalTo("no \"request_id\" in query"));
    }
}
