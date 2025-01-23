package atl.classroom.task.crud.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static atl.classroom.task.crud.rabbitmq.RabbitMQConfig.EXCHANGE_NAME;
import static atl.classroom.task.crud.rabbitmq.RabbitMQConfig.ROUTING_KEY;
import static atl.classroom.task.crud.rabbitmq.RabbitMQConfigTopic.EXCHANGE_NAME_TOPIC;
import static atl.classroom.task.crud.rabbitmq.RabbitMQConfigTopic.ROUTING_KEY_PERSONNEL;

@Component
public class RabbitMQProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @SneakyThrows
    public void sendMessage(String message) {

        ObjectMapper objectMapper = new ObjectMapper();
        Person person = new Person("Alice", 25);
        String json = objectMapper.writeValueAsString(person);
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, json);

//        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, message);
    }

    // TOPIC
    public void sendMessage2(String message) {
        rabbitTemplate.convertAndSend(EXCHANGE_NAME_TOPIC, ROUTING_KEY_PERSONNEL, message);
    }
}
