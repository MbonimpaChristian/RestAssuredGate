package uploadFile;

import base.RestResource;
import constants.StatusCode;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigLoader;

import java.io.File;

public class FileUpload {

    @Test
    public void fileUploadTest() {

        String filePath = ConfigLoader.getFilePath();
        System.out.println("File path from config: " + filePath);

        Assert.assertNotNull(filePath, "file.path is missing in config.properties");

        File file = new File(filePath);

        Assert.assertTrue(file.exists(), "File does not exist: " + file.getAbsolutePath());

        Response response = RestResource.uploadFile(file);

        Assert.assertEquals(response.statusCode(), StatusCode.CODE_200.getCode());
        Assert.assertTrue(response.getContentType().contains("application/json"));

        System.out.println(response.asPrettyString());
    }
}