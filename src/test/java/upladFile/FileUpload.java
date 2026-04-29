package upladFile;

import constants.StatusCode;
import org.testng.IDynamicGraph;
import org.testng.annotations.Test;
import utils.ConfigLoader;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class FileUpload {

    @Test
    public void upload_file_multipart_form(){
        File fileToUpload = new File("file.txt");

        given()
                .baseUri(ConfigLoader.getUploadBaseUrl())
                .multiPart("file", fileToUpload)
                .when()
                .post("/post")
                .then()
                .log().all()
                .statusCode(StatusCode.CODE_200.getCode())
                .body("headers.content-type", containsString("multipart/form-data"));
    }
}
