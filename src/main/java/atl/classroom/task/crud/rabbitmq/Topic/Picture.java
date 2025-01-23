package atl.classroom.task.crud.rabbitmq.Topic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Picture {
    private String name;
    private String type;
    private String source;
    private Integer size;
}
