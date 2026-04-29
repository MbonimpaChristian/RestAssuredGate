package urlencoded;

import base.DummyAPI;
import base.RestResource;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigLoader;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static utils.FakerUtils.getFirstName;

public class FormEncodedTest {

    @Test
    public void urlEnconded() {
        DummyAPI.echoPost(getFirstName());
    }
}
