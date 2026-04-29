package group4;

import io.restassured.response.Response;

import java.util.HashMap;

import static base.SpecBuilder.getAccountRequestSpec;
import static base.SpecBuilder.getResponseSpec;
import static io.restassured.RestAssured.given;
import static routes.Routes.API;
import static routes.Routes.TOKEN;

public class RestResource {

    public static Response postAccount(HashMap<String, String> formParams){

        return
                given(getAccountRequestSpec()).
                        formParams(formParams).
                    when().
                        post(API + TOKEN).
                    then().
                        spec(getResponseSpec()).
                        extract().
                        response();

    }
}
