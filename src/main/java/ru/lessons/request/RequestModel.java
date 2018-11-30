package ru.lessons.request;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.authentication.*;
import io.restassured.builder.*;
import io.restassured.http.ContentType;
import io.restassured.specification.*;

import static ru.lessons.EndPoints.*;

public abstract class RequestModel {

    public static RequestSpecification getRequestSpecification() {
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName(USER_LOGIN);
        authScheme.setPassword(USER_PASS);
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(BASE_PATH)
                .setAuth(authScheme)
                .addFilter(new AllureRestAssured())
                .build();
    }

    public static ResponseSpecification getResponseSpecification() {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();
    }

}