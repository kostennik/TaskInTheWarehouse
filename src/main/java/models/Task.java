package models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonAutoDetect

@Entity
@Table(name = "tasks")
public class Task implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "description_task")
    private String descriptionTask;

    @Column(name = "priority")
    private Boolean priority;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "time")
    private Date timestamp;

    public Task(String userName, String descriptionTask, Boolean priority, int quantity, Date timestamp) {
        this.userName = userName;
        this.descriptionTask = descriptionTask;
        this.priority = priority;
        this.quantity = quantity;
        this.timestamp = timestamp;
    }
}

