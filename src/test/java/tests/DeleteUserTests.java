package tests;

import base.RestResource;
import constants.StatusCode;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteUserTests {

    @Test
    public void testDeleteUserValid() {
        Response response = RestResource.deleteUser(1);

        Assert.assertEquals(response.statusCode(), StatusCode.CODE_200);
        Assert.assertTrue(response.asString().contains("isDeleted"));
    }


    @Test
    public void testDeleteInvalidUser() {
        Response response = RestResource.deleteUser(99999);

        Assert.assertEquals(response.statusCode(), StatusCode.CODE_404);
    }
}
