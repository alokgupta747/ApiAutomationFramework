package basetest;

import com.jayway.jsonpath.JsonPath;
import httpclient.GetRequest;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import services.UserService;
import utility.PayloadReader;

import java.util.Map;
import java.util.logging.Logger;

public class UserTest extends BaseTestAnotation{
    UserService userService;
    Map<String, String> authenticationHeaders;
    Logger logger = Logger.getLogger(GetRequest.class.getName());
    /**
     * Initializes the pre-requirements to start the test.
     */
    @Override
    public void setUpBaseConditionsAndData() {
        payloadReader = new PayloadReader();
//        authenticationHeaders = testdata.getMagentoClientHeaderCredentials();
        userService = new UserService(testdata.getUserURL());
    }

    @Test(description = "Verify User Details")
    public void VerifyUserDetails() {
        Response response = userService.getUserResponse();
        softAssert.assertEquals(response.getStatusCode(), 200);
        logger.info("UpdateCustomerGroup API is giving 200 status");
        softAssert.assertAll();
    }
}
