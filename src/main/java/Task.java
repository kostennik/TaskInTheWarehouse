import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;

@JsonAutoDetect
public class Task implements Serializable {
    private int id;
    private String username;
    private String descriptionTask;
    private String priority;
    private int quantity;
    private long timeUTC;

    public Task(int id, String username, String descriptionTask, String priority, int quantity) {
        this.id = id;
        this.username = username;
        this.descriptionTask = descriptionTask;
        this.priority = priority;
        this.quantity = quantity;
    }

    public Task(String username, String descriptionTask, String priority, int quantity) {
        this.username = username;
        this.descriptionTask = descriptionTask;
        this.priority = priority;
        this.quantity = quantity;
    }

    public Task() {
    }

    public Task(int id, String username, String descriptionTask, String priority, int quantity, long timeUTC) {
        this.id = id;
        this.username = username;
        this.descriptionTask = descriptionTask;
        this.priority = priority;
        this.quantity = quantity;
        this.timeUTC = timeUTC;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription_task() {
        return descriptionTask;
    }

    public void setDescription_task(String description_task) {
        this.descriptionTask = description_task;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", descriptionTask='" + descriptionTask + '\'' +
                ", priority='" + priority + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}

