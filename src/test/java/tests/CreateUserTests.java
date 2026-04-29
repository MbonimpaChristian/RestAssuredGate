package tests;

import base.RestResource;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class CreateUserTests {

    @Test
    public void testCreateUserValid() {

        Map<String, Object> payload = new HashMap<>();
        payload.put("firstName", "John");
        payload.put("lastName", "Doe");

        Response response = RestResource.createUser(payload);

        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertTrue(response.equals(matchesJsonSchemaInClasspath("schemas/createUserSchema.json")));
//        Assert.assertEquals(response.jsonPath().getString("firstName"), "John");

    }

    @Test
    public void testCreateUserEmptyBody() {

        Response response = RestResource.createUser("{}");

        Assert.assertTrue(response.statusCode() >= 400);
    }

}
