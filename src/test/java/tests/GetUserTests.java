package tests;

import base.RestResource;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class GetUserTests {

    @Test
    public void testGetAllUsers() {
        Response response = RestResource.getAllUsers();

        response.then()
                .body(matchesJsonSchemaInClasspath("schemas/allUsersSchema.json"));

        System.out.println("Response time: " + response.getTime());
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.getTime() < 3000);
        Assert.assertTrue(response.getContentType().contains("application/json"));

    }

    @Test
    public void testGetSingleUser() {
        Response response = RestResource.getUser(1);

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("id"), 1);

        response.then()
                .body(matchesJsonSchemaInClasspath("schemas/singleUserSchema.json"));
    }

    @Test
    public void testGetInvalidUser() {
        Response response = RestResource.getUser(99999);

        Assert.assertEquals(response.statusCode(), 404);
    }
}