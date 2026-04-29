package group4;

import io.restassured.response.Response;

import java.util.HashMap;

import static base.SpecBuilder.getRequestSpec;
import static base.SpecBuilder.getResponseSpec;
import static io.restassured.RestAssured.given;
import static routes.Routes.AUTH;
import static routes.Routes.LOGIN;

public class RestResource {

    public static Response postAccount(HashMap<String, String> formParams){

        return
                given(getRequestSpec()).
                        body(formParams).
                    when().
                        post(AUTH + LOGIN).
                    then().
                        spec(getResponseSpec()).
                        extract().
                        response();

    }
}
