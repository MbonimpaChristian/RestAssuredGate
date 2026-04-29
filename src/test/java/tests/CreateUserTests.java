package tests;

import base.RestResource;
import constants.StatusCode;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import payload.pojo.Hair;
import payload.pojo.User;
import utils.FakerUtils;

import java.util.HashMap;
import java.util.Map;



public class CreateUserTests {

    @Test
    public void testCreateUser_by_hashmap() {

        Map<String, Object> payload = new HashMap<>();
        payload.put("firstName", "John");
        payload.put("lastName", "Doe");

        Response response = RestResource.createUser(payload);

        Assert.assertEquals(response.statusCode(), StatusCode.CODE_201);
        Assert.assertEquals(response.jsonPath().getString("firstName"), "John");
    }

    @Test
    public void testCreateUser_by_raw_json_string() {

        String payload = "{\n" +
                "    \"id\": 1,\n" +
                "    \"firstName\": \"John\",\n" +
                "    \"lastName\": \"Doe\"}";

        Response response = RestResource.createUser(payload);

        Assert.assertEquals(response.statusCode(), StatusCode.CODE_201);
        Assert.assertEquals(response.jsonPath().getString("firstName"), "John");
    }

    @Test
    public void testCreateUser_by_pojo() {

        User payload = new User();
        payload.setFirstName(FakerUtils.getFirstName());
        payload.setLastName(FakerUtils.getLastName());
        payload.setHair(FakerUtils.getHair());


        Response response = RestResource.createUser(payload);
        User responseUser = response.as(User.class);

        Assert.assertEquals(response.statusCode(), StatusCode.CODE_201.getCode());
        Assert.assertEquals(responseUser.getFirstName(), payload.getFirstName());
        Assert.assertEquals(responseUser.getLastName(), payload.getLastName());
        Assert.assertEquals(responseUser.getHair().getColor(), payload.getHair().getColor());
    }

    @Test
    public void testCreateUserEmptyBody() {

        Response response = RestResource.createUser("{}");

        Assert.assertTrue(response.statusCode() >= StatusCode.CODE_400.getCode());
    }

}
