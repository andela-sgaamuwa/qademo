package apiTests.authTests;

import apiCalls.AuthenticationCalls;
import apiTests.BaseTest;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class LoginTest extends BaseTest {

    @Test
    public void testLoginWithRightCredentials() throws JSONException {
        Response response = AuthenticationCalls.loginUser("samuel", "pass123");
        //check that the user gets back a token
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.body().toString().contains("auth_token"));
    }

    @Test
    public void testLoginFailsWithWrongCredentials() throws JSONException{
        Response response = AuthenticationCalls.loginUser("malaika", "nopass");
        //check the message that comes back
        Assert.assertEquals(response.getStatusCode(), 400);
        List<String> message = response.jsonPath().get("non_field_errors");
        Assert.assertEquals(message.get(0), "Unable to login with provided credentials.");
    }

}
