package util;

public enum ApiRoutes {
    BASEURI("https://ebyokola.herokuapp.com"),
    LOGIN("/api/auth/login/"),
    REGISTER("/api/auth/register"),
    LOGOUT("/api/auth/logout"),

    GET_POST_BUCKETLISTS("/api/bucketlists/"),
    SINGLE_BUCKETLIST("/api/bucketlists/{pk}"),
    POST_BUCKETLIST_ITEM("/api/bucketlists/{pk}/items/"),
    SINGLE_BUCKETLIST_ITEM("/api/bucketlists/{pk}/items/{id}");

    private String endpoint;

    ApiRoutes(String endpoint){
        this.endpoint = endpoint;
    }

    public String getEndpoint(){
        return endpoint;
    }
}
