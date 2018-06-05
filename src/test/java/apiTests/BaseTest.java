package apiTests;

import apiCalls.AuthenticationCalls;
import com.jayway.restassured.response.Response;
import org.json.JSONException;

public class BaseTest {

    private String token;

    public void setup(String username, String password) throws JSONException {
        Response response = AuthenticationCalls.loginUser(username, password);
        token = response.jsonPath().getString("auth_token");
    }
}
