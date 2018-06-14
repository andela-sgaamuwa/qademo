package entities;

import java.util.List;

public class Bucketlist {
    private int id;
    private String name;
    private String created_by;
    private String date_created;
    private String date_modified;
    private List<BucketlistItem> items;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public String getDate_modified() {
        return date_modified;
    }

    public void setDate_modified(String date_modified) {
        this.date_modified = date_modified;
    }

    public List<BucketlistItem> getItems() {
        return items;
    }

    public void setItems(List<BucketlistItem> items) {
        this.items = items;
    }
}
