package tests;

import base.RestResource;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteUserTests {

    @Test
    public void testDeleteUserValid() {
        Response response = RestResource.deleteUser(1);

        System.out.println("Response time: " + response.getTime());
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.asString().contains("isDeleted"));
    }


    @Test
    public void testDeleteInvalidUser() {
        Response response = RestResource.deleteUser(99999);

        System.out.println("Response time: " + response.getTime());
        Assert.assertEquals(response.statusCode(), 404);
    }
}
