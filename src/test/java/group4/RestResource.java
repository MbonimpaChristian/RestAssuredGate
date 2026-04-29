package group4;

import io.restassured.response.Response;
import routes.Routes;

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

    public static Response createUser(Object payload) {
        return given(getRequestSpec())
                .body(payload)
                .when()
                .post(Routes.POST)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }

    public static Response getAllUsers() {
        return given(getRequestSpec())
                .when()
                .get(Routes.USERS)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }

    public static Response getUser(int userId) {
        return given(getRequestSpec())
                .pathParam("id", userId)
                .when()
                .get(Routes.USERS)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }

    public static Response updateUser(int userId, Object payload) {
        return given(getRequestSpec())
                .pathParam("id", userId)
                .body(payload)
                .when()
                .put(Routes.USERS)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }

    public static Response deleteUser(int userId) {
        return given(getRequestSpec())
                .pathParam("id", userId)
                .when()
                .delete(Routes.USERS)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }

}
