package Backend;

import Base.BaseTestRest;
import com.microsoft.playwright.APIResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.PlaywrightListeners;

@Listeners(PlaywrightListeners.class)
public class ApiTest extends BaseTestRest {

    private APIResponse response;
    Logger logger = LoggerFactory.getLogger(ApiTest.class.getName());
    //Dummy Rest Api is used to performed for api test
    @Test
    public void getAllObject() {
        response = getRequest("/objects");
        Assert.assertTrue(response.ok());
        logger.info("status code " + response.ok());
    }

    @Test
    public void postRequestTest() {
        String payload = "src/test/resources/API/post.json";
        System.out.println(readJsonAsString(payload));
        response = postRequest("/objects", readJsonAsString(payload));
        Assert.assertEquals(response.ok(), "204", "Failed");
        Assert.assertTrue(response.ok(), "oops request failed!!!!!!" + response.status());
        logger.info("status code " + response.ok());
    }
}
