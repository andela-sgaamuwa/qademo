package apiCalls;

import com.jayway.restassured.response.Response;
import util.ApiRoutes;

import static com.jayway.restassured.RestAssured.given;

public class BucketlistCalls {

    public Response createBucketlist(String name, String token){
        Response response =
                given()
                        .baseUri(ApiRoutes.BASEURI.getEndpoint())
                        .header("Accept", "application/json")
                        .header("Authorization", "Token "+token)
                        .body(String.format("{\"name\" : %s}", name))
                        .when()
                        .post(ApiRoutes.GET_POST_BUCKETLISTS.getEndpoint())
                        .then()
                        .extract()
                        .response();
        return response;
    }

    public Response createBucketListItem(String name, int bucketlistId, String token){
        Response response =
                given()
                        .baseUri(ApiRoutes.BASEURI.getEndpoint())
                        .header("Accept", "application/json")
                        .header("Authorization", "Token "+token)
                        .body(String.format("{\"name\" : %s}", name))
                        .when()
                        .post(ApiRoutes.POST_BUCKETLIST_ITEM.getEndpoint())
                        .then()
                        .extract()
                        .response();
        return response;
    }

    public Response getBucketlist(int bucketlistId, String token){
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

    public Response getBucketlistItem(int bucketlistId, int bucketlistItemId, String token){
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
}
