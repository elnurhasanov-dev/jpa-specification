package atl.classroom.task.crud.rabbitmq.Topic;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PictureProducer {

    private final ObjectMapper objectMapper;
    private final RabbitTemplate rabbitTemplate;

    @SneakyThrows
    public void sendMessage(Picture p) {
        var sb = new StringBuilder();

        //1st word is "mobile" or "web" (picture source)
        sb.append(p.getName());
        sb.append(".");

        //2nd word is "small" or "large" based on picture size
        if (p.getSize() > 4000) sb.append("large");
        else sb.append("small");
        sb.append(".");

        //3rd word is picture type
        sb.append(p.getType());

        var routingKey = sb.toString();
        var json = objectMapper.writeValueAsString(p);

        rabbitTemplate.convertAndSend("x.picture", routingKey, json);
    }
}
