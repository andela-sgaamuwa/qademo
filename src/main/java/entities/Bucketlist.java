package entities;

import java.time.LocalDate;
import java.util.List;

public class Bucketlist {
    private int id;
    private String name;
    private String created_by;
    private LocalDate date_created;
    private LocalDate date_modified;
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

    public LocalDate getDate_created() {
        return date_created;
    }

    public void setDate_created(LocalDate date_created) {
        this.date_created = date_created;
    }

    public LocalDate getDate_modified() {
        return date_modified;
    }

    public void setDate_modified(LocalDate date_modified) {
        this.date_modified = date_modified;
    }

    public List<BucketlistItem> getItems() {
        return items;
    }

    public void setItems(List<BucketlistItem> items) {
        this.items = items;
    }
}
