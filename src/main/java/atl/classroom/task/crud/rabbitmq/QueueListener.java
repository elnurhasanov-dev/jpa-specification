package atl.classroom.task.crud.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QueueListener {

    private final ObjectMapper objectMapper;

    @SneakyThrows
    @RabbitListener(queues = "${rabbitmq.queue.person}")
    public void consume(String message) {
        var dto = objectMapper.readValue(message, Person.class);
        System.out.println("Person DTO => " + dto);
    }
}
