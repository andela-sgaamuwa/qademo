package apiTests.bucketlistTests;

import apiCalls.BucketlistCalls;
import apiTests.BaseTest;
import com.jayway.restassured.response.Response;
import entities.Bucketlist;
import entities.BucketlistItem;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BucketListTest extends BaseTest{
    private int bucketlistId;
    private Bucketlist bucketlist;
    private BucketlistItem bucketlistItem;

    @BeforeClass
    private void setup() throws JSONException {
        super.setup("samuel", "pass123");
    }

    @Test
    public void createBucketList() throws JSONException{
        Response response = BucketlistCalls.createBucketlist("new", token);
        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertEquals(response.jsonPath().get("name"), "new");
        // clean up delete the created bucketlist
        BucketlistCalls.deleteBucketlist((Integer) response.jsonPath().get("id"), token);
    }

    @Test
    public void createAlreadyExistentBucketlist() throws JSONException{
        Response initialResponse = BucketlistCalls.createBucketlist("new", token);
        // create another bucketlist with the same name
        Response response = BucketlistCalls.createBucketlist("new", token);
        Assert.assertEquals(response.getStatusCode(), 400);
        // clean up delete the created bucketlist
        BucketlistCalls.deleteBucketlist((Integer) initialResponse.jsonPath().get("id"), token);
    }


    @BeforeGroups("bucketlistItemTests")
    public void setupBucketlist() throws JSONException{
        Response response = BucketlistCalls.createBucketlist("new", token);
        bucketlistId = response.jsonPath().get("id");
    }

    @Test(groups = "bucketlistItemTests")
    public void createBucketlistItem() throws JSONException{
        Response response = BucketlistCalls.createBucketListItem("item1", bucketlistId, token);
        Assert.assertEquals(response.getStatusCode(), 201);
        BucketlistCalls.deleteBucketlistItem(bucketlistId, (Integer) response.jsonPath().get("id"), token);

    }

    @Test(groups = "bucketlistItemTests")
    public void createAlreadyExistentBucketlistItem() throws JSONException{
        Response initialResponse = BucketlistCalls.createBucketListItem("item1", bucketlistId, token);
        Response response = BucketlistCalls.createBucketListItem("item1", bucketlistId, token);
        Assert.assertEquals(response.getStatusCode(), 400);
        BucketlistCalls.deleteBucketlistItem(bucketlistId, (Integer) initialResponse.jsonPath().get("id"), token);
    }

    @Test(groups = "bucketlistItemTests")
    public void createBucketlistItemForNonExistentBucketlist() throws JSONException{
        Response response = BucketlistCalls.createBucketListItem("item1", 39849393, token);
        Assert.assertEquals(response.getStatusCode(), 404);
        Assert.assertEquals(response.jsonPath().get("detail"), "Not found.");
    }


    @AfterGroups(value = "bucketlistItemTests", alwaysRun = true)
    public void cleanUpBucketlist() throws JSONException{
        BucketlistCalls.deleteBucketlist(bucketlistId, token);
    }

    @BeforeGroups(value = "nonfunctionalTests", dependsOnGroups = "bucketlistItemTests", alwaysRun = true)
    public void setUpNonFunctionalTests() throws JSONException{
        Response response = BucketlistCalls.createBucketlist("new", token);
        bucketlist = response.as(Bucketlist.class);
        response = BucketlistCalls.createBucketListItem("item1", bucketlist.getId(), token);
        bucketlistItem = response.as(BucketlistItem.class);
    }

    @Test(groups = "nonfunctionalTests")
    public void checkItemIsCreatedWithDoneAsFalse(){
        Assert.assertFalse(bucketlistItem.isDone());
    }

    @Test(groups = "nonfunctionalTests")
    public void checkBucketlistCreatedWithNoItems(){
        Assert.assertTrue(bucketlist.getItems().isEmpty());
    }

    @Test(groups = "nonfunctionalTests")
    public void checkTheDateFormatReturnedForTheItemAndBucketlist(){
        try{
            new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss").parse(bucketlist.getDate_created());
            new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss").parse(bucketlist.getDate_modified());
            new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss").parse(bucketlistItem.getDate_created());
            new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss").parse(bucketlistItem.getDate_modified());
            assert true;
        }catch (ParseException e){
            assert false;
        }
    }

    @AfterGroups(value = "nonfunctionalTests", alwaysRun = true)
    public void cleanUpNonFunctionalTests() throws JSONException{
        BucketlistCalls.deleteBucketlist(bucketlistId, token);
    }
}
