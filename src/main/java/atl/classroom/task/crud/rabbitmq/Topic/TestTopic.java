package atl.classroom.task.crud.rabbitmq.Topic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/rabbitmq/topic")
@RequiredArgsConstructor
public class TestTopic {

    private final PictureProducer pictureProducer;
    private final List<String> SOURCES = List.of("mobile", "web");
    private final List<String> TYPES = List.of("jpg", "png", "svg");

    @GetMapping
    public void sendTopicMessages() {
        Random r = new Random();
        int low = 100;
        int high = 10000;

        for (int i = 0; i < 10; i++) {
            var p = new Picture();
            p.setName("Picture " + i);
//            p.setSize(r.nextInt(high - low) + low);
            p.setSize(4500);
            p.setSource(SOURCES.get(i % SOURCES.size()));
//            p.setType(TYPES.get(i % TYPES.size()));
            p.setType("svg");
            pictureProducer.sendMessage(p);
        }
    }

}
