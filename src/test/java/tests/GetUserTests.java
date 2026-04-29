package tests;

import base.DummyAPI;
import constants.StatusCode;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class GetUserTests {

    @Test
    public void testGetAllUsers() {
        Response response = DummyAPI.getAllUsers();

        response.then()
                .body(matchesJsonSchemaInClasspath("schemas/allUsersSchema.json"));

        System.out.println("Response time: " + response.getTime());
        Assert.assertEquals(response.statusCode(), StatusCode.CODE_200.getCode());
        Assert.assertEquals(response.statusCode(), StatusCode.CODE_200.getCode());
        Assert.assertTrue(response.getTime() < 3000);
        Assert.assertTrue(response.getContentType().contains("application/json"));

    }

    @Test
    public void testGetSingleUser() {
        Response response = DummyAPI.getUser(1);

        Assert.assertEquals(response.statusCode(), StatusCode.CODE_200.getCode());
        Assert.assertEquals(response.jsonPath().getInt("id"), 1);
    }

    @Test
    public void testGetInvalidUser() {
        Response response = DummyAPI.getUser(99999);

        Assert.assertEquals(response.statusCode(), StatusCode.CODE_404.getCode());
    }

}
