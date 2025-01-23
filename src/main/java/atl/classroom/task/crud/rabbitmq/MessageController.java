package atl.classroom.task.crud.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class MessageController {

    @Autowired
    private RabbitMQProducer producer;

    @PostMapping("/send")
    public String sendMessage(@RequestParam String message) {
        producer.sendMessage(message);
        return "Message sent to RabbitMQ: " + message;
    }

    @PostMapping("/send2")
    public String sendMessage2(@RequestParam String message) {
        producer.sendMessage2(message);
        return "Message sent to RabbitMQ // TOPIC: " + message;
    }
}
