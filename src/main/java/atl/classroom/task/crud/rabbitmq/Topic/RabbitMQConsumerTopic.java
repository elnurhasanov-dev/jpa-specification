package atl.classroom.task.crud.rabbitmq.Topic;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
@RequiredArgsConstructor
public class RabbitMQConsumerTopic {

    private final ObjectMapper objectMapper;

    @SneakyThrows
    @RabbitListener(queues = {"q.picture.image", "q.picture.vector", "q.picture.filter", "q.picture.log"})
    public void listenTopic(String message) {
        var dto = objectMapper.readValue(message, Picture.class);
        System.out.println("Consuming: " + dto);
    }
}
