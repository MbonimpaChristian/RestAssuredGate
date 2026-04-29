package tests;

import base.DummyAPI;
import constants.StatusCode;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteUserTests {

    @Test
    public void testDeleteUserValid() {
        Response response = DummyAPI.deleteUser(1);

        System.out.println("Response time: " + response.getTime());
        Assert.assertEquals(response.statusCode(), StatusCode.CODE_200.getCode());
        Assert.assertTrue(response.asString().contains("isDeleted"));
    }


    @Test
    public void testDeleteInvalidUser() {
        Response response = DummyAPI.deleteUser(99999);

        System.out.println("Response time: " + response.getTime());
        Assert.assertEquals(response.statusCode(), StatusCode.CODE_404.getCode());
    }
}
