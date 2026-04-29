package urlencoded;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import utils.ConfigLoader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FormEncodedTest {

    @Test
    public void testFormUrlEncoded() {
        given()
                .baseUri(ConfigLoader.getUploadBaseUrl())
                .contentType(ContentType.URLENC)
                .formParam("username", "group4")
                .formParam("role", "QA_Engineers")
                .when()
                .post("/post")
                .then()
                .log().all()
                .statusCode(200)
                .body("form.username", equalTo("group4"))
                .body("form.role", equalTo("QA_Engineers"));
    }
}
