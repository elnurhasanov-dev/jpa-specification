package atl.classroom.task.crud.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static atl.classroom.task.crud.rabbitmq.RabbitMQConfig.QUEUE_NAME;

@Component
public class RabbitMQConsumer {

    @SneakyThrows
    @RabbitListener(queues = QUEUE_NAME)
    public void listen(String message) {

        ObjectMapper objectMapper = new ObjectMapper();
        Person person = objectMapper.readValue(message, Person.class);

        System.out.println("Received message: " + message);
        System.out.println("Person Class: " + person);
    }
}
