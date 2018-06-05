package apiCalls;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import groovy.json.JsonException;
import groovy.json.JsonParser;
import org.json.JSONException;
import org.json.JSONObject;
import util.ApiRoutes;

import static com.jayway.restassured.RestAssured.given;

public class AuthenticationCalls {

    public static Response registerUser(String email, String username, String password){

        Response response =
        given()
                .baseUri(ApiRoutes.BASEURI.getEndpoint())
                .header("Accept", "application/json")
                .body(String.format("{\"username\": \"%s\", \"password\": \"%s\", \"email\": \"%s\"}", username, password, email))
                .when()
                .post(ApiRoutes.REGISTER.getEndpoint())
                .then()
                .extract()
                .response();

        return response;
    }

    public static Response loginUser(String username, String password) throws JSONException {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", username);
        jsonObject.put("password", password);
        Response response =
                given()
                        .baseUri(ApiRoutes.BASEURI.getEndpoint())
                        .header("accept", "application/json")
                        .contentType(ContentType.JSON)
                        .body(jsonObject.toString())
                        .when()
                        .post(ApiRoutes.LOGIN.getEndpoint())
                        .then()
                        .extract()
                        .response();

        return response;
    }

}
