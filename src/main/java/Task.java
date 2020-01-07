import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
@JsonAutoDetect
public class Task implements Serializable {
    private int id;
    private String username;
    private String descriptionTask;
    private String priority;
    private int quantity;
    private long timeUTC;
}

