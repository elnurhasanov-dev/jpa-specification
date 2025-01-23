package atl.classroom.task.crud.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QueueSender {

    private final ObjectMapper objectMapper;
    private final RabbitTemplate rabbitTemplate;

    @SneakyThrows
    public void saveToPersonQueue() {
        ObjectMapper objectMapper = new ObjectMapper();
        Person person = new Person("Alice", 25);
        String json = objectMapper.writeValueAsString(person);

        rabbitTemplate.convertAndSend("PERSON_Q", json);
    }
}
