package tests;

import base.RestResource;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class UpdateUserTests {

    @Test
    public void testUpdateUserValid() {

        Map<String, Object> payload = new HashMap<>();
        payload.put("firstName", "UpdatedName");

        Response response = RestResource.updateUser(1, payload);

        System.out.println("Response time: " + response.getTime());
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("firstName"), "UpdatedName");
    }

    @Test
    public void testUpdateInvalidUser() {

        Map<String, Object> payload = new HashMap<>();
        payload.put("firstName", "Fail");

        Response response = RestResource.updateUser(99999, payload);

        System.out.println("Response time: " + response.getTime());
        Assert.assertEquals(response.statusCode(), 404);
    }
}
