package urlencoded;

import base.DummyAPI;

import org.testng.annotations.Test;

import static utils.FakerUtils.getFirstName;

public class FormEncodedTest {

    @Test
    public void urlEnconded() {
        DummyAPI.echoPost(getFirstName());
    }
}
