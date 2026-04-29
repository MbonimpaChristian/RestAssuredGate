package base;

import io.restassured.response.Response;
import utils.ConfigLoader;

import java.io.File;

import static base.SpecBuilder.getRequestSpec;
import static base.SpecBuilder.getResponseSpec;
import static io.restassured.RestAssured.given;

public class RestResource {

    public static Response post(String path, Object payload) {
        return given(getRequestSpec())
                .body(payload)
                .when()
                .post(path)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }

    public static Response get(String path) {
        return given(getRequestSpec())
                .when()
                .get(path)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }

    public static Response get(String path, int id) {
        return given(getRequestSpec())
                .pathParam("id", id)
                .when()
                .get(path)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }

    public static Response put(String path, int id, Object payload) {
        return given(getRequestSpec())
                .pathParam("id", id)
                .body(payload)
                .when()
                .put(path)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }

    public static Response delete(String path, int id) {
        return given(getRequestSpec())
                .pathParam("id", id)
                .when()
                .delete(path)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }

    public static Response encodedTest(String path, String paramName, Object value) {
        return given()
                .baseUri(ConfigLoader.getUploadBaseUrl())
                .formParam(paramName, value)
                .when()
                .post(path)
                .then()
                .extract()
                .response();
    }

    public static Response uploadFile(File file) {

        return given()
                .baseUri(ConfigLoader.getUploadBaseUrl())
                .multiPart("file", file)
                .when()
                .post(ConfigLoader.getUploadPath())
                .then()
                .extract()
                .response();
    }
}