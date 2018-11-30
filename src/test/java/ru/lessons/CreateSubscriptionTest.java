package ru.lessons;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.lessons.request.RequestModel;
import ru.lessons.entity.SubscriptionInfo;

import static io.restassured.RestAssured.given;

public class CreateSubscriptionTest {

    @BeforeEach
    public void CleanUp(){
        DeleteSubscriptionTest.deleteAllSubscriptions();
    }
    @Test
    public void postCreateTinkoffSubscription(){
        given().spec(RequestModel.getRequestSpecification())
                .pathParam("siebel_id", "a.turaev")
                .queryParam("request_id", "6f994192-e701-11e8-9f32-f2801f1b9fd1")
                .queryParam("system_code", "T-API")
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .body(InputData.createJSONObjectTSC())
                .when()
                .post("/contacts/{siebel_id}/subscriptions")
                .then()
                .specification(RequestModel.getResponseSpecification())
                .assertThat()
                .statusCode(200)
                .body("instrument_id", Matchers.equalTo("TCS_SPBXM"))
                .extract()
                .as(SubscriptionInfo.class);
    }


    @Test
    public void postCreateFailSubscription(){
        given().spec(RequestModel.getRequestSpecification())
                .pathParam("siebel_id", "a.turaev")
                .queryParam("request_id", "6f994192-e701-11e8-9f32-f2801f1b9fd1")
                .queryParam("system_code", "T-API")
                .body(InputData.createJSONObjectFail())
                .when()
                .post("/contacts/{siebel_id}/subscriptions")
                .then()
                .specification(RequestModel.getResponseSpecification())
                .assertThat()
                .statusCode(400)
                .body("error", Matchers.equalTo("instrument not found"));
    }
}
