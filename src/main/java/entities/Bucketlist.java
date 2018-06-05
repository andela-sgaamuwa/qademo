package entities;

import java.time.LocalDate;
import java.util.List;

public class Bucketlist {
    private int id;
    private String name;
    private String createdBy;
    private LocalDate dateCreated;
    private LocalDate dateModified;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDate getDateModified() {
        return dateModified;
    }

    public void setDateModified(LocalDate dateModified) {
        this.dateModified = dateModified;
    }

    public List<BucketlistItem> getItems() {
        return items;
    }

    public void setItems(List<BucketlistItem> items) {
        this.items = items;
    }
}
