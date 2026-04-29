package base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static group4.TokenManager.getAccessToken;
import static routes.Routes.BASE_URL;


public class SpecBuilder {

    static String access_token = getAccessToken();

    public static RequestSpecification getRequestSpec(){
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(BASE_URL);
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.log(LogDetail.ALL);
        return requestSpecBuilder.build();
    }

    public static RequestSpecification getTokenRequestSpec(){
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(BASE_URL);
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.addHeader("Authorization", "Bearer" + access_token);
        requestSpecBuilder.log(LogDetail.ALL);
        return requestSpecBuilder.build();
    }

    public static ResponseSpecification getResponseSpec(){
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectContentType(ContentType.JSON);
        responseSpecBuilder.log(LogDetail.ALL);
        return responseSpecBuilder.build();
    }
}
