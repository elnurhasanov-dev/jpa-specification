package atl.classroom.task.crud.rabbitmq;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequiredArgsConstructor
public class MessageController {

    private final QueueSender queueSender;

    @PostMapping("/send")
    public String sendMessage() {
        queueSender.saveToPersonQueue();
        return "Message sent to RabbitMQ";
    }
}
