package tests;

import base.RestResource;
import constants.StatusCode;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetUserTests {

    @Test
    public void testGetAllUsers() {
        Response response = RestResource.getAllUsers();

        Assert.assertEquals(response.statusCode(), StatusCode.CODE_200);
        Assert.assertTrue(response.getTime() < 3000);
        Assert.assertTrue(response.getContentType().contains("application/json"));
    }

    @Test
    public void testGetSingleUser() {
        Response response = RestResource.getUser(1);

        Assert.assertEquals(response.statusCode(), StatusCode.CODE_200);
        Assert.assertEquals(response.jsonPath().getInt("id"), 1);
    }

    @Test
    public void testGetInvalidUser() {
        Response response = RestResource.getUser(99999);

        Assert.assertEquals(response.statusCode(), StatusCode.CODE_404);
    }

}
