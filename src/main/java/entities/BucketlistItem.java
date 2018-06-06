package entities;

import java.time.LocalDate;

public class BucketlistItem {

    private int id;
    private String name;
    private LocalDate date_created;
    private LocalDate date_modified;
    private boolean done;

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

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
