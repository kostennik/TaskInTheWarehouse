import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;
import java.sql.Date;

@JsonAutoDetect
public class Task implements Serializable {
    private int id;
    private String username;
    private String descriptionTask;
    private String priority;
    private int quantity;
    private Date datetime;

    public Task(int id, String username, String task, String priority, int quantity, Date datetime) {
        this.id = id;
        this.username = username;
        this.descriptionTask = task;
        this.priority = priority;
        this.quantity = quantity;
        this.datetime = datetime;
    }

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

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", descriptionTask='" + descriptionTask + '\'' +
                ", priority='" + priority + '\'' +
                ", quantity=" + quantity +
                ", datetime=" + datetime +
                '}';
    }
}

