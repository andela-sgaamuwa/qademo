package apiCalls;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;
import util.ApiRoutes;

import static com.jayway.restassured.RestAssured.given;

public class BucketlistCalls {

    public static Response createBucketlist(String name, String token) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        Response response =
                given()
                        .baseUri(ApiRoutes.BASEURI.getEndpoint())
                        .header("Accept", "application/json")
                        .header("Authorization", "Token "+token)
                        .contentType(ContentType.JSON)
                        .body(jsonObject.toString())
                        .when()
                        .post(ApiRoutes.GET_POST_BUCKETLISTS.getEndpoint())
                        .then()
                        .extract()
                        .response();
        return response;
    }

    public static Response createBucketListItem(String name, int bucketlistId, String token) throws JSONException{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        Response response =
                given()
                        .baseUri(ApiRoutes.BASEURI.getEndpoint())
                        .header("Accept", "application/json")
                        .header("Authorization", "Token "+token)
                        .contentType(ContentType.JSON)
                        .body(jsonObject.toString())
                        .when()
                        .post(ApiRoutes.POST_BUCKETLIST_ITEM.getEndpoint(), bucketlistId)
                        .then()
                        .extract()
                        .response();
        return response;
    }

    public static Response getBucketlist(int bucketlistId, String token){
        Response response =
                given()
                        .baseUri(ApiRoutes.BASEURI.getEndpoint())
                        .header("Accept", "application/json")
                        .header("Authorization", "Token "+token)
                        .when()
                        .get(ApiRoutes.SINGLE_BUCKETLIST.getEndpoint(), bucketlistId)
                        .then()
                        .extract()
                        .response();
        return response;
    }

    public static Response getBucketlistItem(int bucketlistId, int bucketlistItemId, String token){
        Response response =
                given()
                        .baseUri(ApiRoutes.BASEURI.getEndpoint())
                        .header("Accept", "application/json")
                        .header("Authorization", "Token "+token)
                        .when()
                        .get(ApiRoutes.SINGLE_BUCKETLIST_ITEM.getEndpoint(), bucketlistId, bucketlistItemId)
                        .then()
                        .extract()
                        .response();
        return response;
    }

    public static Response getAllBucketlists(String token){
        Response response =
                given()
                        .baseUri(ApiRoutes.BASEURI.getEndpoint())
                        .header("Accept", "application/json")
                        .header("Authorization", "Token "+token)
                        .when()
                        .get(ApiRoutes.GET_POST_BUCKETLISTS.getEndpoint())
                        .then()
                        .extract()
                        .response();
        return response;
    }

    public static Response deleteBucketlist(int bucketlistId, String token){
        Response response =
                given()
                        .baseUri(ApiRoutes.BASEURI.getEndpoint())
                        .header("Accept", "application/json")
                        .header("Authorization", "Token "+token)
                        .when()
                        .delete(ApiRoutes.SINGLE_BUCKETLIST.getEndpoint(), bucketlistId)
                        .then()
                        .extract()
                        .response();
        return response;
    }

    public static Response deleteBucketlistItem(int bucketlistId, int bucketlistItemId, String token){
        Response response =
                given()
                        .baseUri(ApiRoutes.BASEURI.getEndpoint())
                        .header("Accept", "application/json")
                        .header("Authorization", "Token "+token)
                        .when()
                        .delete(ApiRoutes.SINGLE_BUCKETLIST_ITEM.getEndpoint(), bucketlistId, bucketlistItemId)
                        .then()
                        .extract()
                        .response();
        return response;
    }
}
