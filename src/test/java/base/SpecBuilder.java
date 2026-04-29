package base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class SpecBuilder {

    static String access_token = "";

    public static RequestSpecification getRequestSpec(){
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://api.spotify.com");
        requestSpecBuilder.setBasePath("/v1");
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.addHeader("Authorization", "Bearer " + access_token);
        requestSpecBuilder.log(LogDetail.ALL);
        return requestSpecBuilder.build();
    }

    //Renewing the access Token
    public static RequestSpecification getAccountRequestSpec(){
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://accounts.spotify.com");
        requestSpecBuilder.setContentType(ContentType.URLENC);
        requestSpecBuilder.addHeader("Authorization", "Basic " + "MTg2MWUwZGM5MmQzNDI0MTk5NzQ3OTM3Y2E5NGEyOTU6NDFkNjJlY2ZmNDRkNDc1MmI4N2JkYWI4NDIzODNkNjc=");
        requestSpecBuilder.log(LogDetail.ALL);
        return requestSpecBuilder.build();
    }

    public static ResponseSpecification getResponseSpec(){
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectStatusCode(200);
        responseSpecBuilder.expectContentType(ContentType.JSON);
        responseSpecBuilder.log(LogDetail.ALL);
        return responseSpecBuilder.build();
    }
}
