package tests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import routes.Routes;
import utils.ConfigLoader;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.lessThan;

public class UserSchemaValidationTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = ConfigLoader.getBaseUrl();

    }

    @Test
    public void validateCreateUserSchema() {
        String requestBody = """
            {
              "firstName": "Chris",
              "lastName": "Mbonimpa",
              "age": 25
            }
            """;

        given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .log().all()
                .when()
                .post(Routes.CREATE_USER)
                .then()
                .log().all()
                .statusCode(201)
                .contentType("application/json")
                .time(lessThan(3000L))
                .body(matchesJsonSchemaInClasspath("schemas/createUserSchema.json"));
    }


    @Test
    public void validateSingleUserSchema() {
        given()
                .header("Content-Type", "application/json")
                .pathParam("id", 1)
                .log().all()
                .when()
                .get(Routes.GET_SINGLE_USER)
                .then()
                .log().all()
                .statusCode(200)
                .contentType("application/json")
                .time(lessThan(3000L))
                .body(matchesJsonSchemaInClasspath("schemas/singleUserSchema.json"));
    }

    @Test
    public void validateGetUsersSchema() {
        given()
                .header("Content-Type", "application/json")
                .log().all()
                .when()
                .get(Routes.GET_USERS)
                .then()
                .log().all()
                .statusCode(200)
                .contentType("application/json")
                .time(lessThan(3000L))
                .body(matchesJsonSchemaInClasspath("schemas/getUsersSchema.json"));
    }
}